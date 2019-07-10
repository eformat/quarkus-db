# Quarkus DB Testing using Testcontainers library

- https://www.testcontainers.org/
- https://www.youtube.com/watch?v=xtQ1GmVpPP0

## Run tests using mariadb

- application.properties
- TestContainersMariaDbTestResource.java

```
quarkus.datasource.url=jdbc:mariadb://localhost:3306/developer
quarkus.datasource.driver=org.mariadb.jdbc.Driver
```

Run tests

```
mvn compile test
```

## Run tests using postgresql

- application.properties
- TestContainersPostgresqlDbTestResource.java

```

```

Run tests

```
mvn compile test
```

## Local DB

Run postgresql locally

```
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \
    --name postgres-quarkus-db -e POSTGRES_USER=developer \
    -e POSTGRES_PASSWORD=developer -e POSTGRES_DB=developer \
    -p 5432:5432 postgres:10.5
```

Run application

```
mvn quarkus:dev
```

