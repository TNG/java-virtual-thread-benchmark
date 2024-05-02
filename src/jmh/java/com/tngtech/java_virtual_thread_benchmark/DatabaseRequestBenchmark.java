package com.tngtech.java_virtual_thread_benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class DatabaseRequestBenchmark {
    private static final int COUNT = 1000;
    public static final int N_THREADS = 200;

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(N_THREADS);
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static ExecutorService virtualThreadPerTaskExecutor = Executors.newVirtualThreadPerTaskExecutor();

    @TearDown(Level.Trial)
    public void tearDown() throws InterruptedException {
        fixedThreadPool.shutdown();
        cachedThreadPool.shutdown();
        virtualThreadPerTaskExecutor.shutdown();

        fixedThreadPool.awaitTermination(1, TimeUnit.HOURS);
        cachedThreadPool.awaitTermination(1, TimeUnit.HOURS);
        virtualThreadPerTaskExecutor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Benchmark
    public void withOSThread(Blackhole blackhole) throws InterruptedException {
        DatabaseRequest.runOnExecutor(fixedThreadPool, COUNT, blackhole::consume);
    }

    @Benchmark
    public void withOSThreadNoLimit(Blackhole blackhole) throws InterruptedException {
        DatabaseRequest.runOnExecutor(cachedThreadPool, COUNT, blackhole::consume);
    }

    @Benchmark
    public void withVirtualThread(Blackhole blackhole) throws InterruptedException {
        DatabaseRequest.runOnExecutor(virtualThreadPerTaskExecutor, COUNT, blackhole::consume);
    }

    @Benchmark
    public void withReactor(Blackhole blackhole) throws InterruptedException {
        Flux.range(1, COUNT)
            .publishOn(Schedulers.boundedElastic())
            .flatMap(i -> ReactorDatabaseRequest.handleRequest(blackhole::consume))
            .blockLast();
    }
}
