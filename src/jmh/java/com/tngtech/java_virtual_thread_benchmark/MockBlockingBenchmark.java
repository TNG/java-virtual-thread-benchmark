package com.tngtech.java_virtual_thread_benchmark;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.concurrent.Executors;

public class MockBlockingBenchmark {
    private static final int COUNT = 1000;
    public static final int N_THREADS = 200;

    @Benchmark
    public void withOSThread() throws InterruptedException {
        try (var executor = Executors.newFixedThreadPool(N_THREADS)) {
            MockBlockingRequest.runOnExecutor(executor, COUNT);
        }
    }

    @Benchmark
    public void withVirtualThread() throws InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            MockBlockingRequest.runOnExecutor(executor, COUNT);
        }
    }

    @Benchmark
    public void withReactor() throws InterruptedException {
        ReactorMockBlockingRequest.run(COUNT);
    }
}
