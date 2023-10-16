# Hosts file path in windows 10
* C:\Windows\System32\drivers\etc
* Open cmd as administrator and navigate to above location and run below command
```
notepad hosts
```
------
# Open current folder explorer from cmd
* from cmd
```
explorer .
```
------
# Open chrome and open url
```
"C:\Program Files\Google\Chrome\Application\chrome.exe" "http://localhost:7474"
```
------
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
* Identity `PID`
* Execute below command to force kill
```
taskkill /pid [pid number] /f
taskkill /pid 1258 /f
```