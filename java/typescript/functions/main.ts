function function1(){
    console.log("function1()");
}
function1(); // calling function1()

function function2(message){
    console.log(message);
}
function2("hello");

let studentName = function(name){
    console.log(name);
}
studentName("jack");

// arrow function. similar to lambda in java
let empName = (name) => console.log(name);
empName("jill");

let message = (message) => console.log(message);
message("world");

let function4 = (message: string) => console.log(message);
function4("hello jack");
// function4(10); // this line will give compilation error

let function3 = () => console.log("hello world");
function3();

let draw = (point) => {
    console.log("point.x = " + point.x)
    console.log("point.y = " + point.y)
}
draw({
    x: 10, 
    y: 20
})

// variable type declaration is called - Inline Annotation
let draw2 = (point: {x: number, y: number}) => {
    console.log("point.x = " + point.x)
    console.log("point.y = " + point.y)
}
draw2({
    x: 10, 
    y: 20,
    // name: "jack" // this line will give compilation error
})