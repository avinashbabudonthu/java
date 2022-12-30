# Linux Commands

## present working directory
```
pwd
```

## list of files
```
ls
```

## list all files including hidden
```
ls -a
```

## open explorer from present working directory
```
start .
open .
```

## Rename file
### Solution 1
* Create a copy of the existing file with the new desired name and then delete the old file
* This creates a copy of the same file with a new name in the same location
```
$ cp oldfile newfile
```
* This will delete the old file keeping the newfile intact
```
rm oldfile
```
### Solution 2
* This just moves the old file, to a new name
```
$mv old-file-name  new-file-name
```

## Rename file to different location
* If you want to change not only the name of the file, but also it’s location, use the following command
```
$ mv RR2 newdir/.
```

## Rename Multiple files
* In order to rename multiple files at once we can make use of wildcard characters (for ex: ‘*’). In the below example we will rename all the files with .txt to .dat
```
$ mv *.txt *.dat
```
* For example: we have a file with a name RR#.txt, whereas the filename should contain only alphanumeric values instead of any special characters. This can be fixed with the following command
```
$ mv RR?.txt RR1.txt
```

## Rename directory
* Renaming a directory in Linux and Unix is similar to renaming a file. All we need to do is replace the file name with the directory name that is to be renamed
* For example, if we wanted to rename the directory “RR1” to “ST1”, then we can use the following command
```
$ mv RR1 ST1
```

## Verbose
* If you’re renaming a number of files, or doing other mass operations, you may want to track what is happening. Linux has an easy way of doing that with the -v or -verbose option
```
$ mv -v source.txt new_source.txt
```

## Mass move and rename
* Linux has another command, mmv, which stands for mass, move and rename. This is extremely helpful for renaming multiple files at a go. Its utility is not just limited to renaming of files. It can be used for moving, linking and appending multiple files as well. The reason why I like it most because it is the safest way to do these tasks. mmv does it all without any sudden destruction of files due to collisions of target names with existing file names. Moreover, before doing anything, mmv tries to identify any errors that would result from the entire set of actions specified and equips the user with the option of either terminating before beginning, or proceeding by avoiding the offending parts
```
$ mmv [options]
```
* This should give you a good insight into how to rename files in Linux. If you want to try out more options, just use the ‘man’ command, and Linux will list out all the options, along with how to use them
```
$ man move
```

## Download and install jdk 8
* download jdk rpm
```
wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u141-b15/336fa29ff2bb4ef291e347e091f7f4a7/jdk-8u141-linux-x64.rpm
```
* Install JDK 8
```
sudo yum install -y jdk-8u141-linux-x64.rpm
```

# Execute java jar file
```
java -jar [jar-file-name].jar
```

# Execute java jar file as demon
```
nohup java -jar zuul-eureka/accounts-service.jar &
```

# To delete everything in a directory
```
rm /path/to/dir/*
```

# To remove all sub-directories and files
```
rm -r /path/to/dir/*
rm -rfv /home/user1/data/

-r: Remove directories and their contents recursively
-f: Force option. In other words, ignore nonexistent files and arguments, never prompt. Dangerous option. Be careful
-v: Verbose option. Show what rm is doing on screen
```

# To see what is being done when deleting all files in directory pass the `-v` option to the rm command
```
rm -v /home/user1/data/*
```

# Using tar Utility
* A tar.gz file is a combination of a .tar file and a .gz file. It is an archive file with several other files inside it, which is then compressed
```
tar –xvzf file-name.tar.gz
```
* The basic command is tar, followed by four options
	* x – instructs tar to extract the files from the zipped file
	* v – means verbose, or to list out the files it’s extracting
	* z – instructs tar to decompress the files – without this, you’d have a folder full of compressed files
	* f – tells tar the filename you want it to work on
* To instruct tar to put the extracted unzipped files into a specific directory, enter
```
tar –xvzf documents.tar.gz –C /home/user/folder-name
```
* To create a tar.gz file, use the following command. The addition of the –z option is what signals tar to compress the files
```
tar –cvzf documents.tar.gz ~/Documents
```
* To add multiple files to a tar file, use the command
	* c – creates a new archive
	* v – verbose, meaning it lists the files it includes
	* f – specifies the name of the file
	* x - option tells tar to extract the files
```
tar -cvf documents.tar ~/Documents
```
* Install python pip in linux:
```
sudo apt-get install python-pip
```
* Install aws cli
```
sudo pip install --upgrade awscli
```