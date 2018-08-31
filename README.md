# Multi-tenancy database Spring Boot demo project

This is an example of spring application working with multiple oracle databases.

## How to start

1. Run tenant databases

```bash
docker run -d --name tenant1 -p 12511:1521 wnameless/oracle-xe-11g
docker run -d --name tenant2 -p 12512:1521 wnameless/oracle-xe-11g
```

sid: xe
username: system
password: oracle

system/oracle@localhost

```bash
docker run --name test_db1 -e MYSQL_ROOT_PASSWORD=my-secret-pw \
        -e MYSQL_DATABASE=test_db1 -e MYSQL_USER=db_user1 -e MYSQL_PASSWORD=db_pwd \
        -d -p 33061:3306 mysql:8

```