package com.tngtech.java_virtual_thread_benchmark;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UDPRequest implements Runnable {

    @SneakyThrows
    public static void runOnExecutor(ExecutorService threadPool, int count) throws InterruptedException, SocketException {
        try (DatagramSocket socket = new DatagramSocket()) {
            var futures = new ArrayList<Future>(count);

            for (int i = 0; i < count; i++) {
                var future = threadPool.submit(new UDPRequest(socket));
                futures.add(future);
            }

            for (Future future : futures) {
                future.get();
            }
        }
    }

    private final DatagramSocket socket;

    public UDPRequest(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    @SneakyThrows
    public void run() {
        byte[] buf = "Hello, World!".getBytes();

        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 12345);
        socket.send(packet);
    }
}
