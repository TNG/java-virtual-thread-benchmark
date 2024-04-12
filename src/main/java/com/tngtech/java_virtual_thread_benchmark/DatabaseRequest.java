package com.tngtech.java_virtual_thread_benchmark;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class DatabaseRequest implements Runnable {
    private final Consumer<Object> consumer;

    public DatabaseRequest(Consumer<Object> consumer) {
        this.consumer = consumer;
    }

    public static void runOnExecutor(ExecutorService threadPool, long count, Consumer<Object> consumer) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            threadPool.submit(new DatabaseRequest(consumer));
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, java.util.concurrent.TimeUnit.DAYS);
    }

    @Override
    public void run() {
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {

            while (rs.next()) {
                consumer.accept(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static HikariDataSource ds = new HikariDataSource();

    static {
        ds.setJdbcUrl(DatabaseSetting.JDBC_URL);
        ds.setUsername(DatabaseSetting.JDBC_USER);
        ds.setPassword(DatabaseSetting.JDBC_PASSWORD);
    }

    public static void main(String[] args) {
        new DatabaseRequest(System.out::println).run();
    }
}
