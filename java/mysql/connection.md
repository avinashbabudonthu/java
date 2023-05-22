# Connecting to MySQL using New Authentication Plugin
# Authentication plugin caching_sha2_password cannot be loaded: The specified module could not be found
* Open cmd. Go to MySql bin folder `C:\Program Files\MySQL\MySQL Server 5.7\bin`
* Execute following command
```
mysql -u root -p
```
* Enter password
* Create new user named `nativeuser`
```
create user 'nativeuser'@'localhost' identified with mysql_native_password by 'new_password';
```
* Grant all privileges to nativeuser
```
grant all privileges *.* to 'nativeuser' @'localhost';
```
* Go to mysql workbench
* Create new connection
* Give new username/password created above
