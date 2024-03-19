package com.tngtech.java_virtual_thread_benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.Executors;

@State(Scope.Benchmark)
public class HibernateRequestBenchmark {
    private static final int COUNT = 1000;
    public static final int N_THREADS = 200;

    @Setup(Level.Trial)
    public void setUp() {
        HibernateRequest.migrate();
    }

    @Benchmark
    public void withOSThread(Blackhole blackhole) throws InterruptedException {
        try (var executor = Executors.newFixedThreadPool(N_THREADS)) {
            HibernateRequest.runOnExecutor(executor, COUNT, blackhole::consume);
        }
    }

    @Benchmark
    public void withVirtualThread(Blackhole blackhole) throws InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            HibernateRequest.runOnExecutor(executor, COUNT, blackhole::consume);
        }
    }
}
