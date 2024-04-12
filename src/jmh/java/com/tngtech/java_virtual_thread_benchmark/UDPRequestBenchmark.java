package com.tngtech.java_virtual_thread_benchmark;

import org.openjdk.jmh.annotations.Benchmark;

import java.net.SocketException;
import java.util.concurrent.Executors;

public class UDPRequestBenchmark {
    private static final int COUNT = 1000;
    public static final int N_THREADS = 200;

    @Benchmark
    public void withOSThread() throws InterruptedException, SocketException {
        try (var executor = Executors.newFixedThreadPool(N_THREADS)) {
            UDPRequest.runOnExecutor(executor, COUNT);
        }
    }

    @Benchmark
    public void withOSThreadNoLimit() throws InterruptedException, SocketException {
        try (var executor = Executors.newCachedThreadPool()) {
            UDPRequest.runOnExecutor(executor, COUNT);
        }
    }

    @Benchmark
    public void withVirtualThread() throws InterruptedException, SocketException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            UDPRequest.runOnExecutor(executor, COUNT);
        }
    }
}
