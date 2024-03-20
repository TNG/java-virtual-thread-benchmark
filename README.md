Java Virtual Thread Benchmark
---

A simple benchmark to compare the performance of Java Virtual Threads, Java Threads and Reactor Core,
based on scenarios with jdbc and hibernate. 

This is the support repo for the [Melbourne Java & JVM users group event](https://www.meetup.com/melbourne-java-jvm-users-group/events/299472731/).
While this repository may not be actively maintained following the event, community contributions to further enhance or improve this benchmark are always welcome.

## How this benchmark works
We benchmark the use cases with JMH, with 1000 concurrent requests to a class method that request a database through a connection pool.
We treat the finish time of the last request as the finish time of an operation (ops in the table).
The table contains the number of operations per second (ops/s) for each use case.

This scenario is mainly used to test the throughput of the different approaches.

## How to run the benchmark
1. Make sure following denendencies are installed:
    - Java 21
    - Docker
    - Docker Compose
2. Create a `data` folder on the root of the project
3. Run the following command to start the database:
    ```bash
    docker-compose up
    ```
4. Run the following command to run the benchmark:
    ```bash
    ./gradlew jmh
    ```

## Results
Please see [results.txt](./results.txt)

## Benchmark details
- For OS threads and virtual threads, we use the same code (`MockBlockingRequest`, `DatabaseRequest`, `HibernateRequest`), with different
`ExecutorService`, while for reactor core we use a different implementation (`ReactorDatabaseRequest`, `ReactorMockBlockingRequest`).
- We use the same database connection pool for the thread use cases (HikariCP), and use R2DBC for the reactor core use case.
    - HikariCP is by far the fastest connection pool for JDBC, and R2DBC is the fastest for reactive programming.
    - HikariCP does not create extra threads for each request, although it uses some background threads to manage the pool, which is not replaced with virtual threads in this benchmark.
- We use the default settings for the connection pool and R2DBC.
  - Connection pool size: 10

## License
This project is licensed under the Apache License 2.0. For more details, please see the [LICENSE](./LICENSE) file in this repository.
