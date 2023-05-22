// if we declare variable using var then that it is available outside for block 
function function1(){
    for(var i=0; i<10; i++){
        console.log("i="+i)
    }

    console.log("finally i=" + i)
}
function1();

// if we declare variable using let then that it is not available outside for block 
function function2(){
    for(let j=0; j<10; j++){
        console.log("j="+j)
    }

    // console.log("finally i=" + i) // uncommenting this will give compilation error
}
function2();

// declare any type variable
let a: any;
a = 10;
a = 'a';

// declare number type variable
let b: number;
b = 20;
// b = "b"; // this will give compilation error

// boolean
let enabled: boolean;
enabled = true;
enabled = false;

// string
let str: string
str = "jack";

// array of numbers
let numberArray: number[];
let numberArray2: number[] = [1,2,3]; // initialization
let anyArray: any[] = [10, 'a', "jack", true];

// constant
const hello = "Hello";

// enum
enum Days { Sunday, Monday, Tuesday}
let day = Days.Monday;

enum Colors { Red = 10, Green = 20, Blue = 30}
let color = Colors.Blue;

// type casting or type assertions
let message;
message = "hello";
(<string>message).endsWith("lo");
(message as string).endsWith("lo");