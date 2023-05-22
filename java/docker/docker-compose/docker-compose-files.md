# Run 2 mysql containers and connect to docker network
* docker-compose.yml
```
version: "3"

services:

  mysql-1:
   image: mysql:5
   networks:
       - my-network-1
       - my-network-2
   environment:
       - MYSQL_ROOT_PASSWORD=admin
       - MYSQL_DATABASE=database1
   depends_on:
       - "mysql-2"
      
  mysql-2:
    image: mysql:5
    networks:
      - my-network-1
      - my-network-2
    environment:
    - MYSQL_ROOT_PASSWORD=admin
    - MYSQL_DATABASE=database1

networks:
  my-network-1:
  
  my-network-2:
```
* Run docker compose
```
docker-compose up
docker-compose up -d
```
* Stop containers using docker compose. This container not only stops the containers but also removes
```
docker-compose down
```