package com.tngtech.java_virtual_thread_benchmark;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class ReactorDatabaseRequest {

    private static final ConnectionFactory connectionFactory = ConnectionFactories.get(DatabaseSetting.R2DBC_URL);

    public static Mono<Void> handleRequest(Consumer<Object> consumer) {
        return Flux.usingWhen(
                connectionFactory.create(),
                connection ->
                    Flux.from(connection.createStatement("SELECT 1").execute())
                        .flatMap(result -> result.map((row, metadata) -> row.get(0, Integer.class))),
                Connection::close)
            .doOnNext(consumer)
            .then();
    }

    public static void main(String[] args) {
        ReactorDatabaseRequest.handleRequest(System.out::println).block();
    }
}
