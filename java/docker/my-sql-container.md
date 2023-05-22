# MySQL container
* Run mysql docker container. Below command pull version `5`. Check [dockerhub](https://hub.docker.com/_/mysql) for version
```
docker container run --name my-sql-container-1 -e MYSQL_ROOT_PASSWORD=admin -d mysql:5
```
* Run mysql docker container. Run below command to create database
```
docker container run --name my-sql-container-1 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=database1 -d mysql:5
```

* Check running container
```
docker container ls
```
* Login to container
```
docker container exec -it [container-id] bash
```
* connect to mysql
```
mysql -uroot -p[password-we-gave-while-running-container]
mysql -uroot -padmin
```
* See output like below
```
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2
Server version: 5.7.35 MySQL Community Server (GPL)

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
```
* See databases
```
show databases;
```