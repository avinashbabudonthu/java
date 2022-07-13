// We can execute below scripts in - https://jsbin.com/
// to use ES6 (ECMA script 6)
//jshint esnext:true
var var1 = 100; // normal variable
let var2 = 200; // variable which has scope
const var3 = 300; // constant

console.log(var1);
console.log(var2);
console.log(var3);

const employeeNames = ["jack", "jill", "jim"]; // array
console.log(employeeNames);
employeeNames.push("john"); // pushing new element to array
console.log(employeeNames);

// arrow function
var func1 = () => {
  console.log("inside func1");
}

func1();

// arrow function with arguments
let func2 = (num1, num2) => {
  console.log("num1: " + num1 + ", num2: " + num2);
  const num3 = num1 + num2;
  console.log("num3: " + num3);
}
func2(); // calling method without arguments
func2(10, 20); // calling method with arguments

// arrow function with default argument values
var func3 = (num1 = 10, num2 = 20) => {
  console.log("num1: " + num1 + ", num2: " + num2);
  let num3 = num1 + num2;
  console.log("num3: " + num3);
}
func3(); // executing with default argument values
func3(30, 40); // executing passing arguments

// function with if-else and default argument values
var func4 = (num1, num2 = 10) => {
  console.log("num1: " + num1 + ", num2: " + num2);
  if(num1 < num2){
    console.log("num1 < num2");
  }else{
    console.log("num1 > num2");
  }
}
func4();
func4(5);
func4(15);
func4(5, 15);
func4(20, 10);
