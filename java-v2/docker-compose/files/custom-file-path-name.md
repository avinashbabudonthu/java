### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Run docker compose file passing file path and name using -f flag
* Running kafka docker compose file giving custom path and file name
```
docker compose -f C:\github\java\java-v2\docker-compose\files\docker-compose-1-broker.yml up -d
```
* You can use the compose subcommand to build and manage multiple services in Docker containers
```
docker compose [-f <arg>...] [options] [COMMAND] [ARGS...]
```
* Use `-f` to specify the name and path of one or more Compose files
* Use the -f flag to specify the location of a Compose configuration file

## Specifying multiple Compose files
* You can supply multiple `-f` configuration files. When you supply multiple files, Compose combines them into a single configuration. Compose builds the configuration in the order you supply the files. Subsequent files override and add to their predecessors.
* For example, consider this command line:
```
docker compose -f docker-compose.yml -f docker-compose.admin.yml run backup_db
```
* The docker-compose.yml file might specify a webapp service.
```
services:
  webapp:
    image: examples/web
    ports:
      - "8000:8000"
    volumes:
      - "/data"
```
* If the `docker-compose.admin.yml` also specifies this same service, any matching fields override the previous file. New values, add to the webapp service configuration.
```
services:
  webapp:
    build: .
    environment:
      - DEBUG=1
```
* When you use multiple Compose files, all paths in the files are relative to the first configuration file specified with -f. You can use the --project-directory option to override this base path.
* Use a -f with - (dash) as the filename to read the configuration from stdin. When stdin is used all paths in the configuration are relative to the current working directory.
* The -f flag is optional. If you dont provide this flag on the command line, Compose traverses the working directory and its parent directories looking for a `compose.yaml` or `docker-compose.yaml` file.

## Specifying a path to a single Compose file
* You can use the -f flag to specify a path to a Compose file that is not located in the current directory, either from the command line or by setting up a `COMPOSE_FILE` environment variable in your shell or in an environment file.
* For an example of using the -f option at the command line, suppose you are running the Compose Rails sample, and have a compose.yaml file in a directory called sandbox/rails. You can use a command like docker compose pull to get the postgres image for the db service from anywhere by using the -f flag as follows:
```
docker compose -f ~/sandbox/rails/compose.yaml pull db
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)