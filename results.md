## MacBook Pro 16, M3 Max 14C, 36GB RAM, macOS 14.4, Amazon Corretto 21.0.2
DB Deployed as native application

| Benchmark                                 | Mode | Cnt | Score   | Error | Units |
|-------------------------------------------|------|-----|---------|-------|-------|
| DatabaseRequestBenchmark.withOSThread          | thrpt | 15  | 104.422 | ±0.117 | ops/s |
| DatabaseRequestBenchmark.withOSThreadNoLimit   | thrpt | 15  |  35.152 | ±0.042 | ops/s |
| DatabaseRequestBenchmark.withReactor           | thrpt | 15  |  98.977 | ±2.639 | ops/s |
| DatabaseRequestBenchmark.withVirtualThread     | thrpt | 15  | 105.601 | ±0.557 | ops/s |
| HibernateRequestBenchmark.withOSThread         | thrpt | 15  | 100.554 | ±0.298 | ops/s |
| HibernateRequestBenchmark.withOSThreadNoLimit  | thrpt | 15  |  45.415 | ±1.011 | ops/s |
| HibernateRequestBenchmark.withVirtualThread    | thrpt | 15  | 102.178 | ±0.340 | ops/s |
| MockBlockingBenchmark.withOSThread             | thrpt | 15  |   0.198 | ±0.001 | ops/s |
| MockBlockingBenchmark.withReactor              | thrpt | 15  |   0.990 | ±0.001 | ops/s |
| MockBlockingBenchmark.withVirtualThread        | thrpt | 15  |   0.990 | ±0.001 | ops/s |
| UDPRequestBenchmark.withOSThread               | thrpt | 15  | 149.921 | ±3.299 | ops/s |
| UDPRequestBenchmark.withOSThreadNoLimit        | thrpt | 15  |  73.095 | ±1.800 | ops/s |
| UDPRequestBenchmark.withVirtualThread          | thrpt | 15  | 144.611 | ±3.090 | ops/s |
