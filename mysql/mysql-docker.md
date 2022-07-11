## MySQL Docker Container
* Pull mysql docker image
```
docker pull mysql
docker pull mysql:5.7.29
```
* Check docker image
```
docker images
```
* Run docker container
```
docker run --name mysql-docker -p 3308:3306 -e MYSQL_ROOT_PASSWORD=practice_admin -e MYSQL_DATABASE=practice -e MYSQL_USER=practice_admin -e MYSQL_PASSWORD=practice_admin -d mysql:5.7.29
```
* Check docker container
```
docker ps
docker ps --all
docker container ls
```
* Connect from Mysql workbench
	* hostname - `localhost`
	* port - `3308`
	* username - `practice_admin`
	* password - `practice_admin`
	* url - `jdbc:mysql://mysql-docker:3306/practice`