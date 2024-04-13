#!/usr/bin/env bash

docker run --name demo-postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=postgres \
  -p 5432:5432 \
  -v /var/lib/postgresql/data \
  -d postgres:9.6