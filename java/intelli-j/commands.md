# commands
------
* cut the line
```
ctrl x
```
* delete line
```
ctrl y
```
* fold method or block
```
ctrl -
```
* expand method or block
```
ctrl +
```
* move line down
```
alt sht down-arrow
```
* move line down
```
alt sht up-arrow
```
* move method up
```
move to method starting line
ctrl sht up-arrow
```
* move method down
```
move to method starting line
ctrl sht down-arrow
```
* check the parameter information
```
ctrl p
```
* Search class
```
ctrl n
```
* navigate back
```
ctrl alt left-arrow
```
* select section
```
ctrl w
```
* shrink section
```
ctrl shift w
```
* add static import
```
alt enter
```
* format
```
ctrl alt l
```
* remove unwanted imports
```
ctrl alt o
```
* generate constructors/getters/setters
```
alt insert -> select required option
```
* open method
```
ctrl b
```
* open implemented method
```
ctrl alt b
```
* open declaration from implementation method
```
ctrl u
```
* Version control like Git popup
```
alt `
```
* auto remove imports
```
ctrl shift a
type "optimize imports on the fly"
Enable check box next to "Optimize imports on the fly"
```
------
# Generate serial version UID in Intellij
* Without any plugins
* You just need to enable highlight: (Idea v.2016, 2017 and 2018, previous versions may have same or similar settings)
```
File -> Settings -> Editor -> Inspections -> Java -> Serialization issues -> Serializable class without 'serialVersionUID' - set flag and click 'OK'. (For Macs, Settings is under IntelliJ IDEA -> Preferences...)
```
* For Idea v. 2022.1 (Community and Ultimate) it's on:
```
File -> Settings -> Editor -> Inspections -> JVM Languages -> Serializable class without 'serialVersionUID' - set flag and click 'OK'
```
* Now, if your class implements Serializable, you will see highlight and alt+Enter on class name will ask you to generate private static final long serialVersionUID.
* Faster way to find this setting - you might use hotkey `Ctrl+Shift+A (find action)`, type `Serializable class without 'serialVersionUID'` - the first is the one
------