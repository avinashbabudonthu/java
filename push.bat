@echo off
set HTTPS_PROXY=
echo -----------------------------------------------
cd /d %cd%
echo echo Present working directory : %cd%
echo -----------------------------------------------
echo Pulling latest commits before push
git pull
echo -----------------------------------------------
echo Checking status:
git status
echo -----------------------------------------------
echo Adding files to staging area
git add .
echo Added to staging area
echo -----------------------------------------------
echo Checking status:
git status
echo -----------------------------------------------
echo Committing:
::set /p commitMessage=Enter Commit Message: 
::git commit -m "%commitMessage%"
git commit -m "java"
echo Committed
echo -----------------------------------------------
echo Pushing:
git push
echo Pushed
echo -----------------------------------------------
pause
