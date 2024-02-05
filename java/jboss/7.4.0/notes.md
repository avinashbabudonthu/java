# Download
* Download required version from this link - https://developers.redhat.com/products/eap/download?source=sso

# Documentation
* Installation guide - https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html/installation_guide/index

# Zip archive Installation
* Download JBoss EAP (Enterprise Application Platform) from here - https://developers.redhat.com/products/eap/download?source=sso
* Signup to redhat portal
* Extract the zip file
* Open cmd & Go to extracted folder
* Run command
```
bin\add-user.bat
```
* Enter username - `jboss`, password - `P@ssw0rd`
* Follow with instructions
* Run command
```
bin\standalone.bat
```
* Open this for Management console - http://localhost:9990
* Open - http://localhost:8080
* Click `Management console`
* Enter credentials created above
* Now succefully logged into JBoss
* Reference - https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html/installation_guide/index

# Setup Oracle Datasoource
* Download ojdbc jar files - https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
* Start jboss server
```
bin\stanalone.bat
```
* Start Jboss cli
```
bin\jboss-cli.bat
```
* If `disconnect` then type `connect` Enter
* Add `ojdbc8.jar`
```
module add --name=com.oracle --resources=[path-to-jar-file]\ojdbc8.jar --dependencies=javax.api,javax.transaction.api
```
* Add driver
```
/subsystem=datasources/jdbc-driver=oracle:add(driver-name=oracle,driver-module-name=com.oracle,driver-class-name=oracle.jdbc.driver.OracleDriver)
```
* Check driver added above
```
/subsystem=datasources/jdbc-driver=oracle:read-resource
```
* Add datasource. `[]` brackets means mandatory fields. Remove `[]` while adding values
```
data-source add --name=testOracleDS --jndi-name=java:/jdbc/testOracleDS --driver-name=oracle --connection-url=jdbc:oracle:thin:@[host-address]:[port]/[service-name] --user-name=[username] --password=[password] --jta=true --use-ccm=true --use-java-context=true --enabled=true --user-name=[username] --password=[password] --max-pool-size=10 --min-pool-size=5 --flush-strategy="FailingConnectionOnly"
```
* Check datasource created above
```
/subsystem=datasources/data-source=testOracleDS:read-resource
```
* Reference - https://www.dbi-services.com/blog/configuring-oracle-db-data-source-in-jboss-eap-7-1/
* Reference - https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html-single/configuration_guide/index#datasource_management
* Reference - https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html-single/configuration_guide/index#add_jdbc_driver_core_module_datasources
* Other jdbc driver downloads - https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html-single/configuration_guide/index#jdbc_driver_download_locations