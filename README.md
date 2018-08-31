# Multi-tenancy database Spring Boot demo project

This is an example of spring application working with multiple oracle databases.

The aim of the project is to find out how to define datasource in spring which would survive database reboot.

## How to start

1. Run tenant databases
```bash
docker run --name test_db1 -e MYSQL_ROOT_PASSWORD=my-secret-pw \
        -e MYSQL_DATABASE=test_db1 -e MYSQL_USER=db_user1 -e MYSQL_PASSWORD=db_pwd \
        -d -p 33061:3306 mysql:8
docker run --name test_db2 -e MYSQL_ROOT_PASSWORD=my-secret-pw \
        -e MYSQL_DATABASE=test_db2 -e MYSQL_USER=db_user2 -e MYSQL_PASSWORD=db_pwd \
        -d -p 33062:3306 mysql:8
```

2. run submodules

3. validate result (using httpie for example)

```bash
http :8081/users ; http :8082/users
```

4. restart db and validate result

```bash
docker restart test_db1 &
http :8081/users ; http :8082/users

docker restart test_db1 &
http :8083/users X-TenantID:db1 ; http :8083/users X-TenantID:db2
```
