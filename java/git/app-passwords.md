# Create app passwords in bitbucket
* Login to bitbucket
* Profile Icon
* Personal Settings
* App passwords
* Click `Create app password`
* Give `Label`
* Give `Permissions`
* Click `Create`
* Popup will appear, copy this password. It won't be visible again
* Clone using following command
```
git clone https://USERNAME:APP_PASSWORD@bitbucket.org/Username/repo-name.git
```
* If you already cloned repository, use this 
```
git remote set-url origin https://USERNAME:APP_PASSWORD@bitbucket.org/Username/repo-name.git
```