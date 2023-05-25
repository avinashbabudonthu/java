function add(a, b) {
    return a + b;
}

console.log(add(10, 20)); // 30

// aync function with callback
function print(c) {
    console.log(c);
}

function add2(a, b, callback) { 
    callback(a+b);
}
add2(20, 30, print); // 50
// inline function
add2(30, 40, function(c) {
    console.log(c); // 70
});

// short hand function
add2(40, 50, (c) => {
    console.log(c); // 90
});
add2(50, 60, (c) => console.log(c)); // 110

// let key word
// below code - changes value of a inside if condition
var a = 10;
if(true) {
    var a = 20;
    console.log(a); // 20
}
console.log(a); // 20

var a1 = 10;
if(true) {
    let a1 = 20;
    console.log(a1); // 20
}
console.log(a1); // 10
