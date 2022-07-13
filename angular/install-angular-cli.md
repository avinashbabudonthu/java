# Run following commands from cmd
* Install node first. Refer [install-node-js.md](install-node-js.md). This gives `npm`
* Run below command to install angular cli using `npm`
```
npm insall -g @angular/cli
npm insall -g @angular/cli@latest
```
* Above command for Mac
```
sudo npm insall -g @angular/cli
sudo npm insall -g @angular/cli@latest
```
* `@latest` is not mandatory. If we do not give `latest` will be downloaded by default
* If we want to install specific version
```
npm insall -g @angular/cli@[version-number]
```
* -g : install globally on our machine, so we can use it from anywhere in our machine
* Should see output like below. Package number etc may change
```
+ @angular/cli@12.0.3
added 62 packages from 26 contributors, removed 88 packages, updated 86 packages and moved 1 package in 74.986s
```

# update angular version
* Run following command to update angular version to latest
```
npm install -g @angular/cli
```