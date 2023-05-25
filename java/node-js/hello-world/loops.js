// while loop
var limit = 5;
/*
0
1
2
3
4
*/
var i = 0;
while(i<limit) {
    console.log(i);
    i++;
}

// do while
var j = 0;
do {
    console.log(j);
    j++;
}while(j<limit);

// for
for(i=0;i<limit;i++){
    console.log(i);
}

// for each
var arr1 = [10,20,30,40,50,60,70,80,90,100];
arr1.forEach(function(i) {
    console.log(i);
});
for(var i of arr1){
    console.log(i);
}