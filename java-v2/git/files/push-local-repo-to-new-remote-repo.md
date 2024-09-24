### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Push local repo to new remote repo
* Create new repository in github website
* In local, go to new project location. Open cmd (or) git bash in this location
* Execute below commands from local cmd or git bash 
* Initialize as git repo
```
git init
```
* Check status
```
git status
```
* Add all files to staging area
```
git add *
or
git add .
```
* Check status
```
git status
```
* Commit
```
git commit -m "commit message"
```
* Attach remote repo to local repo. Copy new remote repository URL
```
git remote add origin [copied-remote-repository-url]
```
* Push changes from local repo to remote repo
```
git push -u origin master
```
* Enter credentials
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)