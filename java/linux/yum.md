# YUM - Yellowdog Updater Modified
* open-source command-line as well as graphical-based package management tool for RPM (RedHat Package Manager) based Linux systems
* It allows you to install, update, and remove software packages, and manage Red Hat Enterprise Linux (RHEL) and CentOS Linux
------
# Commands
* Install firefox
```
yum install firefox
```
* The above command will ask for confirmation before installing any package on your system. If you want to install packages automatically without asking for any confirmation, use the option -y as shown below example
```
yum -y install firefox
```
* Install web Server
```
yum -y install httpd
```
* Removing a Package with YUM
```
yum remove firefox
```
* To disable the confirmation prompt just add option `-y`
```
yum -y remove firefox
```
* Updating a Package using YUM
```
yum update mysql
```
* List a Package using YUM. Use the list function to search for the specific package with a name. For example to search for a package called OpenSSH, use the command
```
yum list Openssh
```
* To make your search more accurate, define package names with their version, in case you know. For example to search for a specific version OpenSSH-4.3p2 of the package, use the command
```
yum list Openssh-4.3p2
```
* Search for a Package using YUM. If you don’t remember the exact name of the package, then use the search function to search all the available packages to match the name of the package you specified. For example, to search all the packages that match the word
```
yum search vsftpd
```
* Get Information about a Package using YUM. Say you would like to know the information about a package before installing it. To get information on a package just issue the below command
```
yum search firefox
```
* List all Available Packages using YUM. To list all the available packages in the Yum database, use the below command
```
yum list | less
```
* List all Installed Packages using YUM. To list all the installed packages on a system, just issue the below command, it will display all the installed packages
```
yum list installed | less
```
* Yum Provides Function. Yum provides function is used to find which package a specific file belongs to. For example, if you would like to know the name of the package that has the `/etc/httpd/conf/httpd.conf`
```
yum provides /etc/httpd/conf/httpd.conf
```
* Check for Available Updates using Yum. To find how many installed packages on your system have updates available, check to use the following command
```
yum check-update
```
* Update System using Yum. To keep your system up-to-date with all security and binary package updates, run the following command. It will install all the latest patches and security updates to your system
```
yum update
yum update -y
```
* List all available Group Packages. In Linux, a number of packages are bundled into a particular group. Instead of installing individual packages with yum, you can install a particular group that will install all the related packages that belong to the group. For example to list all the available groups, just issue the following command
```
yum grouplist
```
* Install Group Packages. To install a particular package group, we use the option as groupinstall. For example, to install “MySQL Database“, just execute the below command
```
yum groupinstall 'MySQL Database'
```
* Update a Group Packages. To update any existing installed group packages, just run the following command as shown below
```
yum groupupdate 'DNS Name Server'
```
* Remove Group Packages. To delete or remove any existing installed group from the system, just use the below command
```
yum groupremove 'DNS Name Server'
```
* List Enabled Yum Repositories. To list all enabled Yum repositories in your system, use the following option
```
yum repolist
```
* List all Enabled and Disabled Yum Repositories. The following command will display all enabled and disabled yum repositories on the system
```
yum repolist all
```
* Install a Package from a Specific Repository. To install a particular package from a specific enabled or disabled repository, you must use `--enablerepo` an option in your yum command. For example to Install the PhpMyAdmin package, just execute the command
```
yum --enablerepo=epel install phpmyadmin
```
*  Interactive Yum Shell. Yum utility provides a custom shell where you can execute multiple commands
```
yum shell
```
* Clean Yum Cache
By default yum keeps all the repository enabled package data in /var/cache/yum/ with each sub-directory, to clean all cached files from the enabled repository, you need to run the following command regularly to clean up all the cache and make sure that there is nothing unnecessary space is using
```
yum clean all
```
*  View History of Yum. To view all the past transactions of the yum command
```
yum history
```