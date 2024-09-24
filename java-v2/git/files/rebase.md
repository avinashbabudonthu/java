### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Git Rebase
* Git Rebase & Squash many commits
* open git bash
```
git checkout develop
git pull
git checkout [our-feature-branch]
git rebase -i develop
press i
replace push -> squash
press Esc
:wq
100dd -- meaning of this line -> XXdd removes the XX lines
press i
enter commit message
press esc
:wq
git push -f
```
* Abort rebase
```
git rebase --abort
```
* Reference - https://www.atlassian.com/git/tutorials/rewriting-history/git-rebase
* Reference - Youtube - https://www.youtube.com/watch?v=f1wnYdLEpgI&ab_channel=TheModernCoder
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)