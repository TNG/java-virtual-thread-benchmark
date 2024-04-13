## MacBook Pro 16, M3 Max 14C, 36GB RAM, macOS 14.4, Amazon Corretto 21.0.2
DB Deployed as native application

Benchmark                                       Mode  Cnt    Score    Error  Units
DatabaseRequestBenchmark.withOSThread          thrpt   15   51.902 ±  2.795  ops/s
DatabaseRequestBenchmark.withOSThreadNoLimit   thrpt   15   64.494 ±  0.297  ops/s
DatabaseRequestBenchmark.withReactor           thrpt   15   91.300 ±  1.478  ops/s
DatabaseRequestBenchmark.withVirtualThread     thrpt   15   83.763 ±  0.456  ops/s

HibernateRequestBenchmark.withOSThread         thrpt   15   51.825 ±  0.248  ops/s
HibernateRequestBenchmark.withOSThreadNoLimit  thrpt   15   62.937 ±  0.582  ops/s
HibernateRequestBenchmark.withVirtualThread    thrpt   15   80.092 ±  0.332  ops/s

MockBlockingBenchmark.withOSThread             thrpt   15    0.198 ±  0.001  ops/s
MockBlockingBenchmark.withReactor              thrpt   15    0.994 ±  0.002  ops/s
MockBlockingBenchmark.withVirtualThread        thrpt   15    0.994 ±  0.001  ops/s

UDPRequestBenchmark.withOSThread               thrpt   15   92.801 ±  2.995  ops/s
UDPRequestBenchmark.withOSThreadNoLimit        thrpt   15   69.003 ±  1.482  ops/s
UDPRequestBenchmark.withVirtualThread          thrpt   15  385.987 ±  4.572  ops/s

## MacBook Pro 16, M3 Max 14C, 36GB RAM, macOS 14.4, Amazon Corretto 21.0.2
DB Deployed in Docker on the same device (VM)

Benchmark                                       Mode  Cnt    Score    Error  Units
DatabaseRequestBenchmark.withOSThread          thrpt   15   28.496 ±  0.265  ops/s
DatabaseRequestBenchmark.withOSThreadNoLimit   thrpt   15   28.379 ±  0.545  ops/s
DatabaseRequestBenchmark.withReactor           thrpt   15   33.017 ±  0.128  ops/s
DatabaseRequestBenchmark.withVirtualThread     thrpt   15   31.121 ±  0.240  ops/s

HibernateRequestBenchmark.withOSThread         thrpt   15   27.599 ±  0.193  ops/s
HibernateRequestBenchmark.withOSThreadNoLimit  thrpt   15   27.577 ±  0.361  ops/s
HibernateRequestBenchmark.withVirtualThread    thrpt   15   30.038 ±  0.122  ops/s

MockBlockingBenchmark.withOSThread             thrpt   15    0.198 ±  0.001  ops/s
MockBlockingBenchmark.withReactor              thrpt   15    0.990 ±  0.001  ops/s
MockBlockingBenchmark.withVirtualThread        thrpt   15    0.992 ±  0.001  ops/s

UDPRequestBenchmark.withOSThread               thrpt   15   95.197 ±  2.051  ops/s
UDPRequestBenchmark.withOSThreadNoLimit        thrpt   15   70.348 ±  1.182  ops/s
UDPRequestBenchmark.withVirtualThread          thrpt   15  376.784 ±  7.889  ops/s

## MacBook Pro 16, M3 Max 14C, 36GB RAM, macOS 14.4, Amazon Corretto 21.0.2
10000 concurrent requests

Benchmark                                      Mode  Cnt  Score   Error  Units
DatabaseRequestBenchmark.withOSThread         thrpt   15  8.411 ± 0.069  ops/s
DatabaseRequestBenchmark.withOSThreadNoLimit  thrpt   15  4.097 ± 0.117  ops/s
DatabaseRequestBenchmark.withReactor          thrpt   15  9.179 ± 0.057  ops/s
DatabaseRequestBenchmark.withVirtualThread    thrpt   15  8.282 ± 0.098  ops/s

HibernateRequestBenchmark.withOSThread         thrpt   15  7.922 ± 0.146  ops/s
HibernateRequestBenchmark.withOSThreadNoLimit  thrpt   15  3.926 ± 0.098  ops/s
HibernateRequestBenchmark.withVirtualThread    thrpt   15  7.973 ± 0.077  ops/s
