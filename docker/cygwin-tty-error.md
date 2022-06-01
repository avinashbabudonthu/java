(Extra) For cygwin users: how to avoid TTY errors
Just a quick note for anyone using cygwin as their terminal. In the next video, you're going to be running the command:

docker container run -it ubuntu

For some reason, on cygwin, this is likely to fail with the error:

the input device is not a TTY.  If you are using mintty, try prefixing the command with 'winpty'

If this happens, then this is the workaround:

1) Download a copy of winpty using:

curl -L https://github.com/rprichard/winpty/releases/download/0.4.3/winpty-0.4.3-cygwin-2.8.0-x64.tar.gz > winpty.tar.gz

(Note: this is to download the latest release at the time of writing, for a 64 bit machine. For a current list of releases see https://github.com/rprichard/winpty/releases)

2) Unpack with tar xvf winpty.tar.gz

3) Change directories into the extracted folder, and then into /bin. Eg cd winpty-0.4.3-cygwin-2.8.0-x64/bin/

4) Move all the files to the cygwin path:  cp * /usr/local/bin/



From now on, whenever you are running a command in "interactive mode" - ie using the -it parameter, you can prefix your command with "winpty" - and it should now work:

winpty docker container run -it ubuntu



I hope that helps - this was the reason I used powershell for the recordings, but once I became aware of this workaround I went back to using cygwin all the time. Let me know if you have any problems.

