### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
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
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)