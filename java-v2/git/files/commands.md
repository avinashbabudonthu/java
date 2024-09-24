### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Git Commands
* Git version
```
git --version
git version
```
* Configure the author email address to be used with your commits
```
git config --global user.email "test@gmail.com"
```
* Configure the author name to be used with your commits
```
git config --global user.name "User defined name"
```
* configure the author password
```
git config --global user.password "your password"
```
* Will remove user credential details from local repository
```
git config --local credential.helper ""
```
* Change the default branch to `main`
```
git config --global init.defaultBranch main
```
* List git configs
```
git config --global --list
```
* Clone git repository
```
git clone repository-url
```
* Clone a repository from remote to local with branch name
```
git clone --branch branch_name repo_url
```
* Using username and key in cloning url
```
https://username:passwordOrKey@bitbucket.org/repo/app.git
https://testusername:AbcdqrcqscqHdch123456@bitbucket.org/repo/app.git
```
* Unstage staged files
```
git restore --staged .
```
* Display remote repository name. This gives output `origin`
```
git remote
```
* List all currently configured remote repository URLs
```
git remote -v

origin  https://github.com/avinashbabudonthu/java.git (fetch)
origin  https://github.com/avinashbabudonthu/java.git (push)
```
* Get push remote url
```
git remote get-url --push origin
git remote get-url --all origin

https://github.com/avinashbabudonthu/java.git
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)