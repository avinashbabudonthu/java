var arr1 = [10,20,30,40,50];
console.log(arr1); // [ 10, 20, 30, 40, 50 ]

var arr2 = [10, "jim", true, 'a']
console.log(arr2); // [ 10, 'jim', true, 'a' ]
console.log(arr2[2]); // true

arr2[1] = "jack";
console.log(arr2); // [ 10, 'jack', true, 'a' ]

arr2.push(20);
console.log(arr2); // [ 10, 'jack', true, 'a', 20 ]

/*
[
    10,   'jack',
    true, 'a',
    20,   50,
    60
  ]
*/
arr2.push(50, 60);
console.log(arr2);

arr2.pop();
console.log(arr2); // [ 10, 'jack', true, 'a', 20, 50 ]