package com.tngtech.java_virtual_thread_benchmark;

import reactor.netty.udp.UdpServer;

public class UDPBlackHole {
    public static void main(String[] args) throws InterruptedException {
        UdpServer.create()
            .host("0.0.0.0")
            .port(12345)
            .handle((in, out) -> in.receive().then())
            .bindNow()
            .onDispose()
            .block();
    }
}
