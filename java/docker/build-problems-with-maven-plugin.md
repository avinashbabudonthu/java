# Build Problems with Maven Plugin? Problems running the Maven Build?
* If you’re running Docker Toolbox (Mac or Windows before 10 Pro), then you may have problems either connecting to the Daemon, or you may get obscure errors saying:
```
unable to find valid certification path to requested target
```
* The solution is to run on the command line:
```
docker-machine env 
```
* This will give an output like:
```
export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.100:2376"
export DOCKER_CERT_PATH="XXX"
export DOCKER_MACHINE_NAME="default"
export COMPOSE_CONVERT_WINDOWS_PATHS="true"
```
* Now add the following two tags to the `<configuration>` tag of the Docker Maven plugin configuration, in the pom.xml file:
```
<dockerHost>tcp://192.168.99.100:2376</dockerHost>
<certPath>XXX</certPath>
```
* Make sure the values in the tags match the output your received in the previous step
* Full details at StackOverflow here: [https://stackoverflow.com/questions/46598198](https://stackoverflow.com/questions/46598198)