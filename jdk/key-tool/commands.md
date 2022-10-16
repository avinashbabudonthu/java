# Keytool commands
* Install certificate to local JRE using JDK tool keytool. This will ask for password, enter any user defined password. Default is changeit	
```
keytool -import -trustcacerts -file [path]\[certificate-file-name].cer -alias [any-user-defined-alias-name] -keystore cacerts
Example: keytool -import -trustcacerts -file C:\Work\my_internal_root_ca.cer -alias internal_cert -keystore cacerts
```
* List certificates with alias name internal_cert	
```
keytool -list -keystore cacerts -alias "internal_cert" -storepass changeit
```
* List all certificates in a JRE
```
keytool -list -v -keystore "C:/Program Files/Java/jdk1.8.0_131/jre/lib/security/cacerts"
```
* To print cert contents	
```
keytool -printcert -v -file [path]\[certificate-file-name].cer
Example: keytool -printcert -v -file C:\Work\my_internal_root_ca.cer
```
