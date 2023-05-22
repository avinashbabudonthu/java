## Install Chocolatey
* Open [Chocolatey](https://chocolatey.org/)
* click on `Install Chocolatey Now` button
* scroll down we can see below command:
```
@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"
```
* copy paste above command in cmd