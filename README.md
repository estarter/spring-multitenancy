# Multi-tenancy database Spring Boot demo project

This is an example of spring application working with multiple oracle databases.

## How to start

1. Run tenant databases
```bash
docker run --name test_db1 -e MYSQL_ROOT_PASSWORD=my-secret-pw \
        -e MYSQL_DATABASE=test_db1 -e MYSQL_USER=db_user1 -e MYSQL_PASSWORD=db_pwd \
        -d -p 33061:3306 mysql:8
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
```
