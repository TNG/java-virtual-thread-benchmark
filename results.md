## XPS 13 9310, i7-1195G7, 4C8T, 32GB RAM, Fedora 38, Amazon Corretto 21.0.2
DB Deployed in Docker on the same machine

Benchmark                                     Mode  Cnt   Score    Error  Units
DatabaseRequestBenchmark.withOSThread        thrpt   15  29.441 ±  0.451  ops/s
DatabaseRequestBenchmark.withReactor         thrpt   15  61.496 ±  1.033  ops/s
DatabaseRequestBenchmark.withVirtualThread   thrpt   15  51.363 ±  0.269  ops/s

HibernateRequestBenchmark.withOSThread       thrpt   15  28.007 ±  0.193  ops/s
HibernateRequestBenchmark.withVirtualThread  thrpt   15  45.871 ±  0.466  ops/s

MockBlockingBenchmark.withOSThread           thrpt   15   0.200 ±  0.001  ops/s
MockBlockingBenchmark.withReactor            thrpt   15   0.999 ±  0.001  ops/s
MockBlockingBenchmark.withVirtualThread      thrpt   15   0.999 ±  0.001  ops/s

## AWS EC2 c5.xlarge, 4vCPU, 8GB RAM, Amazon Linux 2, Amazon Corretto 21.0.2
HVM
DB Deployed in Docker on the same machine

Benchmark                                       Mode  Cnt    Score    Error  Units
DatabaseRequestBenchmark.withOSThread          thrpt   15   17.012 ±  0.132  ops/s
DatabaseRequestBenchmark.withOSThreadNoLimit   thrpt   15   20.419 ±  0.332  ops/s
DatabaseRequestBenchmark.withReactor           thrpt   15   45.681 ±  0.676  ops/s
DatabaseRequestBenchmark.withVirtualThread     thrpt   15   22.164 ±  0.189  ops/s
HibernateRequestBenchmark.withOSThread         thrpt   15   14.274 ±  0.354  ops/s
HibernateRequestBenchmark.withOSThreadNoLimit  thrpt   15   18.010 ±  0.481  ops/s
HibernateRequestBenchmark.withVirtualThread    thrpt   15   19.480 ±  0.134  ops/s
MockBlockingBenchmark.withOSThread             thrpt   15    0.199 ±  0.001  ops/s
MockBlockingBenchmark.withReactor              thrpt   15    0.998 ±  0.001  ops/s
MockBlockingBenchmark.withVirtualThread        thrpt   15    0.998 ±  0.001  ops/s
UDPRequestBenchmark.withOSThread               thrpt   15   41.844 ±  0.702  ops/s
UDPRequestBenchmark.withOSThreadNoLimit        thrpt   15   61.406 ±  0.733  ops/s
UDPRequestBenchmark.withVirtualThread          thrpt   15  209.680 ± 40.358  ops/s


## AWS EC2 c5.xlarge, 4vCPU, 8GB RAM, Amazon Linux 2, Amazon Corretto 21.0.2
HVM
DB Deployed in EC2 r5.large 2vCPU, 16GB RAM, Amazon Linux 2

Benchmark                                       Mode  Cnt    Score    Error  Units
DatabaseRequestBenchmark.withOSThread          thrpt   15   21.215 ±  0.403  ops/s
DatabaseRequestBenchmark.withOSThreadNoLimit   thrpt   15   25.144 ±  0.184  ops/s
DatabaseRequestBenchmark.withReactor           thrpt   15   49.116 ±  1.131  ops/s
DatabaseRequestBenchmark.withVirtualThread     thrpt   15   17.233 ±  1.037  ops/s

HibernateRequestBenchmark.withOSThread         thrpt   15   20.328 ±  0.327  ops/s
HibernateRequestBenchmark.withOSThreadNoLimit  thrpt   15   25.056 ±  0.374  ops/s
HibernateRequestBenchmark.withVirtualThread    thrpt   15   17.381 ±  0.151  ops/s

MockBlockingBenchmark.withOSThread             thrpt   15    0.199 ±  0.001  ops/s
MockBlockingBenchmark.withReactor              thrpt   15    0.998 ±  0.001  ops/s
MockBlockingBenchmark.withVirtualThread        thrpt   15    0.998 ±  0.001  ops/s

UDPRequestBenchmark.withOSThread               thrpt   15   40.856 ±  0.225  ops/s
UDPRequestBenchmark.withOSThreadNoLimit        thrpt   15   71.385 ±  1.115  ops/s
UDPRequestBenchmark.withVirtualThread          thrpt   15  203.488 ± 30.678  ops/s

## MacBook Pro 16, M3 Max 14C, 36GB RAM, macOS 14.4, Amazon Corretto 21.0.2
DB Deployed in Docker on the same device (VM)

Benchmark                                     Mode  Cnt   Score    Error  Units
DatabaseRequestBenchmark.withOSThread        thrpt   15  32.926 ±  0.420  ops/s
DatabaseRequestBenchmark.withReactor         thrpt   15  88.997 ± 32.811  ops/s
// 105 ops/s normal, with one iteration at 45 ops/s
DatabaseRequestBenchmark.withVirtualThread   thrpt   15  36.593 ±  0.583  ops/s

HibernateRequestBenchmark.withOSThread       thrpt   15  32.182 ±  0.305  ops/s
HibernateRequestBenchmark.withVirtualThread  thrpt   15  35.393 ±  0.314  ops/s

MockBlockingBenchmark.withOSThread           thrpt   15   0.198 ±  0.001  ops/s
MockBlockingBenchmark.withReactor            thrpt   15   0.990 ±  0.001  ops/s
MockBlockingBenchmark.withVirtualThread      thrpt   15   0.991 ±  0.001  ops/s

UDPRequestBenchmark.withOSThread             thrpt   15  122.751 ± 2.692  ops/s
UDPRequestBenchmark.withVirtualThread        thrpt   15  428.106 ± 8.956  ops/s
