package com.tngtech.java_virtual_thread_benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

public class DatabaseRequestBenchmark {
    private static final int COUNT = 1000;
    public static final int N_THREADS = 200;

    @Benchmark
    public void withOSThread(Blackhole blackhole) throws InterruptedException {
        try (var executor = Executors.newFixedThreadPool(N_THREADS)) {
            DatabaseRequest.runOnExecutor(executor, COUNT, blackhole::consume);
        }
    }

    @Benchmark
    public void withVirtualThread(Blackhole blackhole) throws InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            DatabaseRequest.runOnExecutor(executor, COUNT, blackhole::consume);
        }
    }

    @Benchmark
    public void withReactor(Blackhole blackhole) throws InterruptedException {
        Flux.range(1, COUNT)
            .publishOn(Schedulers.boundedElastic())
            .flatMap(i -> ReactorDatabaseRequest.handleRequest(blackhole::consume))
            .blockLast();
    }
}
