# Jenkins Installation
* Download Jenkins 2.x from - http://jenkins.io
* Delete folder `user-directory/.jenkins` to remove any old installation settings
* Start jenkins using command
```
java -jar softwares\jenkins.war --httpPort=10000 --prefix=/jenkins
```
* For fresh setup while starting jenkins Password for installation will be displayed. Copy this
* open
```
http://localhost:10000/jenkins
````
* Unlock Jenkins screen displayed
* Paste the password copied above
* click Continue
* Click "Install suggested plugins". This step will install required plugins
* Once all plugins installed will be redirected to create admin user. Create admin user
* Once user is setup. click Start to use Jenkins