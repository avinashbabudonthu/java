# Basic Git Concepts
* Default branch name: main
* Default remote name: origin
* Current branch reference: HEAD
* Parent of HEAD: HEAD^ or HEAD~1
* Grandparent of HEAD: HEAD^^ or HEAD~2
------
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
* Create a branch
```
git branch <branch>
```
* Create a branch and switch to it using the checkout command
```
git checkout -b <branch>
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
* `git branch` useful flags
```
-a: Display all branches (local & remote)
-r: Display remote branches
-v: Display branches with last commit
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
* If you want to add all changes made to tracked files & commit
```
git commit -a -m "<message>"
or
git commit -am "<message>"
```
* Push the changes to current branch. Send all commits from local repository to remote repository
```
git push
```
* Push changes to master branch
```
git push <remote name> <branch>

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
* Add a remote repository
```
git remote add <remote name> <url>
```
* If you haven't connected your local repository to a remote server, To add a remote server to a local repository
```
git remote add origin [repo_url]
```
* Create a new local repository (or) Initialize a local repository. The `<directory>` is optional. If you don't specify it, the current directory will be used
```
git init
git init <directory>
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
* Display remote repositories
```
git remote
```
* List all currently configured remote repository URLs
```
git remote -v
```
* Display the commit history
```
git log
```
* Remove files from the staging area
```
git reset HEAD file-name
or
git reset <file>
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
* Rename a remote repository
```
git remote rename <old name> <new name>
```
* Fetch changes from a remote repository
```
git fetch <remote name>
```

* Fetch changes from a particular branch
```
git fetch <remote name> <branch>
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
* You can also remove it from staging area only using `--cached` flag
```
git rm --cached <file>
```
* If remove file from directory then git does not know about it, then execute following commands
```
git add -u
git status
git commit -m "commit-message"
```
* Move or rename a file
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
* Checkout a previous commit
```
git checkout <commit id>
```
* Revert a commit
```
git revert <commit id>
```
* Reset a commit
```
git reset <commit id>
```
* You can also add the --hard flag to delete all changes, but use it with caution
```
git reset --hard <commit id>
```
* Display the changes to unstaged files
```
git diff
```
* You can also use the --staged flag to display the changes to staged files
```
git diff --staged
```
* Display the changes between two commits
```
git diff <commit id 01> <commit id 02>
```
------
# Useful flags:
* --no-ff: Create a merge commit even if the merge resolves as a fast-forward
* --squash: Squash all commits from the specified branch into a single commit
* Fast forward merge\
![picture](images/fast-forward-merge.jpg)
* Non fast forward merge\
![picture](images/non-fast-forward-merge.jpg)
* It is suggested to not use the `--squash` flag as it will squash all commits into a single commit, leading to a messy commit history
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
------
# How to create a stash
* The simplest command to stash your changes is `git stash`
```
$ git stash
Saved working directory and index state WIP on master; d7435644 Feat: configure graphql endpoint
```
* By default, `git stash` stores (or `stashes`) the uncommitted changes (staged and unstaged files) and overlooks untracked and ignored files. Usually, you don't need to stash untracked and ignored files, but sometimes they might interfere with other things you want to do in your codebase.
* You can use additional options to let `git stash` take care of untracked and ignored files:
	* stash untracked files
		* git stash -u or git stash --include-untracked
	* stash untracked files and ignored files
		* git stash -a or git stash --all
* To stash specific files, you can use the command `git stash -p` or `git stash –patch`
```
$ git stash --patch
diff --git a/.gitignore b/.gitignore
index 32174593..8d81be6e 100644
--- a/.gitignore
+++ b/.gitignore
@@ -3,6 +3,7 @@
 # dependencies
 node_modules/
 /.pnp
+f,fmfm
 .pnp.js

 # testing
(1/1) Stash this hunk [y,n,q,a,d,e,?]?
```
## Listing your stashes
* You can view your stashes with the command `git stash list`. Stashes are saved in a `last-in-first-out (LIFO)` approach
```
$ git stash list
stash@{0}: WIP on master: d7435644 Feat: configure graphql endpoint
```
* By default, stashes are marked as WIP on top of the branch and commit that you created the stash from. However, this limited amount of information isn't helpful when you have multiple stashes, as it becomes difficult to remember or individually check their contents. To add a description to the stash, you can use the command `git stash save <description>`
```
$ git stash save "remove semi-colon from schema"
Saved working directory and index state On master: remove semi-colon from schema

$ git stash list
stash@{0}: On master: remove semi-colon from schema
stash@{1}: WIP on master: d7435644 Feat: configure graphql endpoint
```
## Retrieving stashed changes
* You can reapply stashed changes with the commands git stash apply and git stash pop. Both commands reapply the changes stashed in the latest stash (that is, stash@{0}). A stash reapplies the changes while pop removes the changes from the stash and reapplies them to the working copy. Popping is preferred if you don't need the stashed changes to be reapplied more than once.
* You can choose which stash you want to pop or apply by passing the identifier as the last argument
```
$ git stash pop stash@{1} 
```
```
$ git stash apply stash@{1}
```
## Cleaning up the stash
* It is good practice to remove stashes that are no longer needed. You must do this manually with the following commands:
* `git stash clear` - empties the stash list by removing all the stashes.
* `git stash drop <stash_id>` - deletes a particular stash from the stash list.
## Checking stash diffs
* The command `git stash show <stash_id>` allows you to view the diff of a stash
```
$ git stash show stash@{1}
console/console-init/ui/.graphqlrc.yml        |   4 +-
console/console-init/ui/generated-frontend.ts | 742 +++++++++---------
console/console-init/ui/package.json          |   2 +-
```
* To get a more detailed diff, pass the --patch or -p flag
```
$ git stash show stash@{0} --patch
diff --git a/console/console-init/ui/package.json b/console/console-init/ui/package.json
index 755912b97..5b5af1bd6 100644
--- a/console/console-init/ui/package.json
+++ b/console/console-init/ui/package.json
@@ -1,5 +1,5 @@
 {
- "name": "my-usepatternfly",
+ "name": "my-usepatternfly-2",
  "version": "0.1.0",
  "private": true,
  "proxy": "http://localhost:4000"
diff --git a/console/console-init/ui/src/AppNavHeader.tsx b/console/console-init/ui/src/AppNavHeader.tsx
index a4764d2f3..da72b7e2b 100644
--- a/console/console-init/ui/src/AppNavHeader.tsx
+++ b/console/console-init/ui/src/AppNavHeader.tsx
@@ -9,8 +9,8 @@ import { css } from "@patternfly/react-styles";

interface IAppNavHeaderProps extends PageHeaderProps {
- toolbar?: React.ReactNode;
- avatar?: React.ReactNode;
+ toolbar?: React.ReactNode;
+ avatar?: React.ReactNode;
}

export class AppNavHeader extends React.Component<IAppNavHeaderProps>{
  render()
```
## Checking out to a new branch
* You might come across a situation where the changes in a branch and your stash diverge, causing a conflict when you attempt to reapply the stash. A clean fix for this is to use the command `git stash branch <new_branch_name stash_id>`, which creates a new branch based on the commit the stash was created from and pops the stashed changes to it
```
$ git stash branch test_2 stash@{0}
Switched to a new branch 'test_2'
On branch test_2
Changes not staged for commit:
(use "git add <file>..." to update what will be committed)
(use "git restore <file>..." to discard changes in working directory)
modified: .graphqlrc.yml
modified: generated-frontend.ts
modified: package.json
no changes added to commit (use "git add" and/or "git commit -a")
Dropped stash@{0} (fe4bf8f79175b8fbd3df3c4558249834ecb75cd1)
```
## Stashing without disturbing the stash reflog
* In rare cases, you might need to create a stash while keeping the stash reference log (reflog) intact. These cases might arise when you need a script to stash as an implementation detail. This is achieved by the `git stash create` command; it creates a stash entry and returns its object name without pushing it to the stash reflog
```
$ git stash create "sample stash"
63a711cd3c7f8047662007490723e26ae9d4acf9
```
* Sometimes, you might decide to push the stash entry created via `git stash create` to the stash reflog
```
$ git stash store -m "sample stash testing.." "63a711cd3c7f8047662007490723e26ae9d4acf9"
$ git stash list
stash @{0}: sample stash testing..
```
------
## Using username and key in cloning url
```
https://username:passwordOrKey@bitbucket.org/repo/app.git
https://testusername:AbcdqrcqscqHdch123456@bitbucket.org/repo/app.git
```
