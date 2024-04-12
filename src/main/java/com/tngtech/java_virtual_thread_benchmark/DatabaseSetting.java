package com.tngtech.java_virtual_thread_benchmark;

public class DatabaseSetting {
//    public static final String DB_ADDRESS = "localhost";
    public static final String DB_ADDRESS = "ec2-54-253-212-198.ap-southeast-2.compute.amazonaws.com";

    public static final String JDBC_URL = "jdbc:postgresql://" + DB_ADDRESS + ":5432/postgres";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = "postgres";

    public static final String R2DBC_URL = "r2dbc:pool:postgresql://postgres:postgres@" + DB_ADDRESS + ":5432/postgres";
}
