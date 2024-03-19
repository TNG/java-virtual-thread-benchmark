package com.tngtech.java_virtual_thread_benchmark;

import java.util.concurrent.ExecutorService;

public class MockBlockingRequest implements Runnable {
    public static void runOnExecutor(ExecutorService threadPool, long count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            threadPool.submit(new MockBlockingRequest());
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, java.util.concurrent.TimeUnit.DAYS);
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
