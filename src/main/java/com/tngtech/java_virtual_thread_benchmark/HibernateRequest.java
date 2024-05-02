package com.tngtech.java_virtual_thread_benchmark;

import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class HibernateRequest implements Runnable {
    private final Consumer<Object> consumer;

    public HibernateRequest(Consumer<Object> consumer) {
        this.consumer = consumer;
    }

    public static Logger logger = Logger.getLogger(HibernateRequest.class.getName());

    private static SessionFactory buildSessionFactory() {
        var configuration = new Configuration();
        configuration.setProperty("hibernate.connection.provider_class", "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");
        configuration.setProperty("hibernate.hikari.dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        configuration.setProperty("hibernate.hikari.dataSource.url", DatabaseSetting.JDBC_URL);
        configuration.setProperty("hibernate.hikari.dataSource.user", DatabaseSetting.JDBC_USER);
        configuration.setProperty("hibernate.hikari.dataSource.password", DatabaseSetting.JDBC_PASSWORD);

        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        configuration.addAnnotatedClass(DummyEntity.class);

        return configuration.buildSessionFactory();
    }

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static void migrate() {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            int deleted = session.createMutationQuery("DELETE FROM DummyEntity").executeUpdate();
            logger.info("Deleted " + deleted + " entities");

            for (int i = 0; i < 10; i++) {
                DummyEntity dummyEntity = new DummyEntity();
                dummyEntity.setName("dummy" + i);
                session.persist(dummyEntity);
            }

            transaction.commit();
            logger.info("Migrated");
        }
    }

    @SneakyThrows
    public static void runOnExecutor(ExecutorService threadPool, int count, Consumer<Object> consumer) throws InterruptedException {
        var futures = new ArrayList<Future>(count);

        for (int i = 0; i < count; i++) {
            var future = threadPool.submit(new HibernateRequest(consumer));
            futures.add(future);
        }

        for (Future future : futures) {
            future.get();
        }
    }

    @Override
    public void run() {
        try (var session = sessionFactory.openSession()) {
            List<DummyEntity> entities = session.createSelectionQuery("FROM DummyEntity", DummyEntity.class).list();
            entities.forEach(consumer);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
