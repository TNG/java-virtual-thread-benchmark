package com.tngtech.java_virtual_thread_benchmark;

import reactor.core.publisher.Mono;
import reactor.netty.udp.UdpClient;

public class ReactorUdpRequest {
    private static final UdpClient udpClient = UdpClient.create()
        .host("127.0.0.1")
        .port(12345);

    public static Mono<Void> handleRequest() {
        return udpClient.connect()
            .flatMap(connection -> connection.outbound()
                .sendString(Mono.just("Hello, World!"))
                .then()
                .doFinally(signalType -> connection.dispose())
            )
            .then();
    }

    public static void main(String[] args) {
        ReactorUdpRequest.handleRequest().block();
        ReactorUdpRequest.handleRequest().block();
    }
}
