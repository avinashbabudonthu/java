# Materials in study order
* https://www.w3schools.com/js/default.asp
------
# Random number
* Returns a random number
```
Math.random();
```
* Returns a random integer from 0 to 9
```
Math.floor(Math.random() * 10)
```
* Returns a random integer from 0 to 10
```
Math.floor(Math.random() * 11)
```
* Returns a random integer from 0 to 99
```
Math.floor(Math.random() * 100)
```
* Returns a random integer from 0 to 100
```
Math.floor(Math.random() * 101)
```
* Returns a random integer from 1 to 10
```
Math.floor(Math.random() * 10) + 1
```
* Returns a random integer from 1 to 100
```
Math.floor(Math.random() * 100) + 1
```
* function always returns a random number between min (included) and max (excluded)
```
function getRndInteger(min, max) {
  return Math.floor(Math.random() * (max - min) ) + min;
}
```
* JavaScript function always returns a random number between min and max (both included)
```
function getRndInteger(min, max) {
  return Math.floor(Math.random() * (max - min + 1) ) + min;
}
```