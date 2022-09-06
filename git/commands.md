# Git Commands

* Git version
```
git --version
```

* Overview of all useful commands
```
git help
```

* Complete list of all git commands
```
git help -a
```

* List all git concepts
```
git help -g
```

* Clone git repository
```
git clone repository-url
```

* Clone a repository from remote to local with specific branch_name
```
git clone --branch branch_name repo_url
```

* Current branch
```
git branch
```

* Check all branches
```
git branch -a

git branch --all
```
* Count number of branches
```
git branch -r | wc -l
```
* switch to another branch
```
git checkout branch-name
```

* Create a new branch and switch to it
```
git checkout -b branch-name
```

* Delete the feature branch from local repository
```
git branch -d branch_name
(or)
git branch -D branch_name
(or)
git branch --delete branch_name
```

* Merge branch-1 to current branch
```
git merge branch-1
```
* Merge master to develop
	* switch to develop
		* git checkout develop
	* merge master to develop
		* git merge master
* Merge master to branch-1
```
git merge branch-1 master
```
* Pull latest changes from current branch
```
git pull
```

* Make all files ready to commit. Add all files to staging
```
git add *

git add .
```

* Add file to staging (ready to commit)
```
git add file-name
```

* Add all files with extension .java ready to staging
```
git add **/*.java
```

* Add all files with extension .java and .html ready to staging
```
git add **/*.java **/*.html
```
* Make all files under src/main/java folder ready to commit (add to staging)
```
git add src/main/java/*
```
* Commit changes to local repository
```
git commit -m "commit message"
```
* Push the changes to current branch. Send all commits from local repository to remote repository
```
git push
```
* Push changes to master branch
```
git push origin master
(or)
git push -u origin master
```
* Push specific branch to your remote repository
```
git push origin [branch_name]
```
* Push all branches to your remote repository
```
git push --all origin
```
* Changed files and those you still need to add or commit
```
git status
```
* Revert all local changes
```
git reset --hard HEAD
```
* Reset local repository and point your local master branch to latest history fetched from remote server
```
git reset --hard origin/master
```
* If you haven't connected your local repository to a remote server, To add a remote server to a local repository
```
git remote add origin [repo_url]
```
* Create a new local repository
```
git init
```
* Create new remote repository and check in local new repository to remote repository
	* Create new repository in github website
	* Go to new project location in command prompt (or) git bash
	* Copy new repository URL
	* Initialize - `git init`
	* Check status - `git status`
	* Add all files to staging area - `git add *`
	* Check status - `git status`
	* Commit to local repo - `git commit -m "commit message"`
	* Attach remote repo to local repo - `git remote add origin [remote-repository-url]`
	* Push changes from local repo to remote repo - `git push -u origin master`
	* Enter credentials

* Revert specific file changes
```
git checkout -- fileName
git checkout -- file1.txt
```

* Revert files with specific extension
```
git checkout -- **/*.java
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
* List all currently configured remote repository URLs
```
git remote -v
```
* Get commit id
```
git log
```
* Remove files from the staging area
```
git reset HEAD file-name
```
* Remove ignored files
```
git clean -fX
```
* Remove ignored and non-ignored files
```
git clean -fx
```
* Remove un tracked directories
```
git clean -fd
```
* Clean repository to initial stage
```
git clean -x -d -f
```
* Revert specific commit
```
git revert commit-id

git revert 0ad5a7a6
```
* Store git credentials. This command will create file named `.git-credentials` in `C:\Users\user-name` folder
```
git config --global credential.helper store
```
* Git configurations list
```
git config --list
```
* Git configurations list with origins
```
git config --list --show-origin
```
* Update git remote url to existing local repo
```
git remote set-url origin git@github.com:avinashbabudonthu/python.git
```
* Remove remote branch from local repo
```
git remote remove <name>
git remote remove heroku
```
* Allow long paths
```
git config --system core.longpaths true
```
* Delete un pushed git local commits
```
git reset --hard origin
git reset --hard origin/<branch>
git reset --hard origin/feature/my-cool-stuff
```
* Delete un pushed git local commits but keep the local work
```
git reset --soft origin
git reset --soft origin/<branch>
git reset --soft origin/feature/my-cool-stuff
```
* Remove file from local git repo. we need to commit after deleting
```
git rm [file-name]
git status
git commit -m "commit-message"
```
* If remove file from directory then git does not know about it, then execute following commands
```
git add -u
git status
git commit -m "commit-message"
```
* Moving files with git
```
git mv [file-name] [folder-name-with-path]
git commit -m "commit-message"
```
* Moving files without git
```
git add -u
git status
git commit -m "commit-message"
```
* Reset local unfinished merge
```
git reset --merge
```
------
# Cherry Pick
* branch1 - commit1
* branch2 - commit2
* cherry pick `commit2` from `branch2` and apply to `branch1`
* check out to branch
```
git checkout branch1
```
* execute the cherry-pick with the following command
```
git cherry-pick commit2
```
* Reference - https://www.atlassian.com/git/tutorials/cherry-pick#:~:text=git%20cherry%2Dpick%20is%20a,be%20useful%20for%20undoing%20changes.
