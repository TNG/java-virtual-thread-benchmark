## AWS EC2 c5.2xlarge, 8vCPU, 16GB RAM, Amazon Linux 2, Amazon Corretto 21.0.2
DB Deployed in Docker on the same machine

Benchmark                                       Mode  Cnt    Score    Error  Units
DatabaseRequestBenchmark.withOSThread          thrpt   15   24.953 ±  0.064  ops/s
DatabaseRequestBenchmark.withOSThreadNoLimit   thrpt   15   33.248 ±  0.598  ops/s
DatabaseRequestBenchmark.withReactor           thrpt   15   39.958 ±  0.546  ops/s
DatabaseRequestBenchmark.withVirtualThread     thrpt   15   40.508 ±  0.192  ops/s

HibernateRequestBenchmark.withOSThread         thrpt   15   23.053 ±  0.111  ops/s
HibernateRequestBenchmark.withOSThreadNoLimit  thrpt   15   31.034 ±  0.077  ops/s
HibernateRequestBenchmark.withVirtualThread    thrpt   15   36.459 ±  0.132  ops/s

MockBlockingBenchmark.withOSThread             thrpt   15    0.199 ±  0.001  ops/s
MockBlockingBenchmark.withReactor              thrpt   15    0.999 ±  0.001  ops/s
MockBlockingBenchmark.withVirtualThread        thrpt   15    0.998 ±  0.001  ops/s

UDPRequestBenchmark.withOSThread               thrpt   15   46.434 ±  0.196  ops/s
UDPRequestBenchmark.withOSThreadNoLimit        thrpt   15   62.732 ±  0.437  ops/s
UDPRequestBenchmark.withVirtualThread          thrpt   15  259.047 ± 13.621  ops/s

## AWS EC2 c5.xlarge, 4vCPU, 8GB RAM, Amazon Linux 2, Amazon Corretto 21.0.2
DB Deployed in Docker on the same machine

Benchmark                                       Mode  Cnt    Score    Error  Units
DatabaseRequestBenchmark.withOSThread          thrpt   15   15.598 ±  0.183  ops/s
DatabaseRequestBenchmark.withOSThreadNoLimit   thrpt   15   18.576 ±  0.146  ops/s
DatabaseRequestBenchmark.withReactor           thrpt   15   23.633 ±  0.212  ops/s
DatabaseRequestBenchmark.withVirtualThread     thrpt   15   20.138 ±  0.191  ops/s

HibernateRequestBenchmark.withOSThread         thrpt   15   13.532 ±  0.174  ops/s
HibernateRequestBenchmark.withOSThreadNoLimit  thrpt   15   16.659 ±  0.389  ops/s
HibernateRequestBenchmark.withVirtualThread    thrpt   15   17.533 ±  0.120  ops/s

MockBlockingBenchmark.withOSThread             thrpt   15    0.199 ±  0.001  ops/s
MockBlockingBenchmark.withReactor              thrpt   15    0.998 ±  0.001  ops/s
MockBlockingBenchmark.withVirtualThread        thrpt   15    0.998 ±  0.001  ops/s

UDPRequestBenchmark.withOSThread               thrpt   15   39.298 ±  0.417  ops/s
UDPRequestBenchmark.withOSThreadNoLimit        thrpt   15   56.916 ±  0.615  ops/s
UDPRequestBenchmark.withVirtualThread          thrpt   15  348.801 ± 30.845  ops/s

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
