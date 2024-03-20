# Sudo command
* `sudo (Super User DO)` command in Linux is generally used as a prefix for some commands that only superusers are allowed to run. If you prefix any command with “sudo”, it will run that command with elevated privileges or in other words allow a user with proper permissions to execute a command as another user, such as the superuser. This is the equivalent of the “run as administrator” option in Windows. The option of sudo lets us have multiple administrators
* These users who can use the sudo command need to have an entry in the sudoers file located at “/etc/sudoers”. Remember that to edit or view the sudoers file you have to use the sudo command. To edit the sudoers file it is recommended to use the “visudo” command
* By default, sudo requires that users authenticate themselves with a password that is the user’s password, not the root password itself. 
* The syntax for `sudo` command: 
```
sudo -V | -h | -l | -v | -k | -K | -s | [ -H ] [-P ] [-S ] [ -b ] | 
[ -p prompt ] [ -c class|- ] [ -a auth_type ] [-r role ] [-t type ] 
[ -u username|#uid ] command
```
* -V The -V (version) option causes sudo to print the version number and exit. If the invoking user is already root, the -V option will print out a list of the defaults sudo was compiled with. 	
```
sudo -V
```
* -l	The -l (list) option will print out the commands allowed (and forbidden) the user on the current host. 	
```
sudo -l
```
* -h or –help	The -h (help) option causes sudo to print a usage message and exit.	
```
sudo -h
```
* -v	If, given the -v (validate) option, sudo will update the user’s timestamp, prompting for the user’s password if necessary. This extends the sudo timeout for another 5 minutes (or as given in sudoers) but does not run a command. This does not give any output. 	
```
sudo -v
```
* -k	The -k (kill) option to sudo invalidates the user’s timestamp. So, the next time sudo is run a password will be required. This option does not require a password and was added to allow a user to revoke sudo permissions from a logout file. 	
```
sudo -k
```
* -K	Similar to the -k option, the -K (sure kill) option is used to remove the user’s timestamp entirely. Likewise, this option does not require a password. 	
```
sudo -K
```
* -b	The -b (background) option tells sudo to run the given command in the background. Note that if you use the -b option you cannot use shell job control to manipulate the process. 	
```
sudo -b [command]
(replace “command” with the command you want run in the background)
```
* -p	the sudo -p prompt command allows you to customize the password prompt that sudo displays when it requests the user’s password. By default, sudo will display a generic password prompt that looks like	
```
sudo -p "Enter your password" [command]
(replace “command” with the command you want run in the background)
```
* -n	The -n option allows sudo to execute a command without prompting for a password. This option is useful when running sudo commands as background jobs or in a shell script. The -n option stands for non-interactive.	
```
sudo -n [command]
(replace “command” with the command you want run in the background)
```
* -u	The -u option causes sudo to run the specified command as a user other than root. To specify a UID instead of a username, use #uid.	
```
sudo -u [user] [command]
(replace “command” with the command you want run in the background)
```
* -s	The -s option runs the shell specified by the SHELL environment variable if it is set or the shell as specified in the file passwd.	
```
sudo -s [command]
(replace “command” with the command you want run in the background)
```
* -H	The -H option sets the HOME environment variable to the home directory of the target user (root by default) as specified in passwd. By default, sudo does not modify HOME.	
```
sudo -H [command]
(replace “command” with the command you want run in the background)
```
* -S	The -S option causes sudo to read the password from standard input instead of the terminal device.	
```
sudo -S [command]
(replace “command” with the command you want run in the background)
```
* -a	The -a option causes sudo to use the specified authentication type when validating the user, as allowed by /etc/login.conf. The system administrator may specify a list of sudo-specific authentication methods by adding an “auth-sudo” entry in /etc/login.conf.	
```
sudo -a [auth-type] [command]
(replace “command” with the command you want run in the background)
```
* -- The `--` flag indicates that sudo should stop processing command line arguments. It is most useful in conjunction with the -s flag.	
```
sudo -- [command]
(replace “command” with the command you want run in the background)
```