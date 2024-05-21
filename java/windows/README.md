# Windows commands
------
* Hosts file path in windows 10 - `C:\Windows\System32\drivers\etc`
* Open cmd as administrator and navigate to above location and run below command
```
notepad hosts
```
* Open current folder explorer from cmd
```
explorer .
```
* Open chrome and open url
```
"C:\Program Files\Google\Chrome\Application\chrome.exe" "https://www.google.com/"
```
* Delete files
```
cd /d C:\my-folder
del file1.txt
del *.txt
```
* Copy files
```
copy C:\my-folder\file1.txt C:\my-folder-2
copy C:\my-folder\*.txt C:\my-folder-2
```
* Rename files
```
ren C:\my-folder\file1.txt C:\my-folder\file1-renamed.txt
```
* In the batch file - get batch file directory
```
%~dp0
```
------
# Force stop service
* Click the `Start` menu
* Click Run or in the search bar type `services.msc`
* Press Enter
* Look for the service and check the `Properties` and identify its service name
* Once found, open a command prompt. Type
```
sc queryex [servicename]
```
* Identify `PID`
* Execute below command to force kill
```
taskkill /pid [pid number] /f
taskkill /pid 1258 /f
```
------
# nslookup
* Stands for `Name Server Lookup`
* Useful command for getting information from the DNS server
![picture](imgs/001-nslookup.jpg)
------
# Install Telnet Client
* Run Command Prompt as Administrator
* Execute the command below
```
pkgmgr /iu:TelnetClient
```
* Type `telnet`
* Enter `q` to quick telnet window
------
