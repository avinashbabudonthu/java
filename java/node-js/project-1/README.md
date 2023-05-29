# Creating node project
* Create empty folder
* Navigate to that folder. Run following command
```
npm init
```
* Follow the instructions
* This creates `package.json` file
* `package.json` file stores `meata data`, `dependencies` of our project
* create [logger.js](logger.js) file
* Call `log` function in [logger.js](logger.js) from [index.js](index.js)
* Import `underscore` module. `underscore` is popular javascript library for several helper functions. Refer https://underscorejs.org/
* Run following commands to import `underscore`. `--save` adds this module as dependency in [package.json](package.json). Check `dependencies` property in [package.json](package.json)
```
npm install underscore -- save
```
* Above command adds `node_modules` folder. This folder used to store external dependencies of our app
* Using `first` function from `underscore` - Refer [index.js](index.js)