package com.tngtech.java_virtual_thread_benchmark;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;

public class UDPRequest implements Runnable {

    public static void runOnExecutor(ExecutorService threadPool, long count) throws InterruptedException, SocketException {
        try (DatagramSocket socket = new DatagramSocket()) {
            for (int i = 0; i < count; i++) {
                threadPool.submit(new UDPRequest(socket));
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
