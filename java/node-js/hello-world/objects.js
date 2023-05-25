// empty object
var student1 = {};
console.log(student1); // {}

// add properties to student object
var student2 = {};
student2.firstName = "jim";
student2.lastName = "jill";
student2.age=25;
console.log(student2); // { firstName: 'jim', lastName: 'jill', age: 25 }

var student3 = {
    firstName: "ana",
    lastName: "ane",
    age: 20
};
console.log(student3); // { firstName: 'ana', lastName: 'ane', age: 20 }
console.log(student3.firstName); // ana
console.log(student3.lastName); // ane
console.log(student3.age); // 20