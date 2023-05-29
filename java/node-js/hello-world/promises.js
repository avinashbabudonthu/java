// function fun1(data, callback) {
//     callback("done");
// }
// fun1(true, (result) => console.log(result));

// above function using promises
function fun1(data) {

    let successMessage = {
        status: 'success',
        message: 'all good'
    };

    let errorMessage = {
        status: 'error',
        message: 'something wrong'
    };

    return new Promise((resolve, reject) => {
        if(typeof data === 'boolean' && data === true) {
            resolve(successMessage);
        }else {
            reject(errorMessage);
        }
    });
}

// { status: 'success', message: 'all good' }
// fun1(true).then(
//     (successMessage) => {
//         console.log(successMessage);
//     },
//     (errorMessage) => {
//         console.log(errorMessage);
//     }
// );

// { status: 'error', message: 'something wrong' }
// fun1(false).then(
//     (successMessage) => {
//         console.log(successMessage);
//     },
//     (errorMessage) => {
//         console.log(errorMessage);
//     }
// );

// chaining promises - writing above 2 fun1 calls in single code
/*
1 - first fun1 call - {"status":"success","message":"all good"}
2 - second fun1 call - {"status":"error","message":"something wrong"}
*/
// fun1(true).then(
//     (successMessage) => {
//         console.log('1 - first fun1 call - ' + JSON.stringify(successMessage));
//         return fun1(false);
//     }
// ).then(
//     (successMessage) => {
//         console.log('2 - second fun1 call - ' + JSON.stringify(successMessage));
//     },
//     (errorMessage) => {
//         console.log('3 - second fun1 call - ' + JSON.stringify(errorMessage));
//     }
// );

// 7 - Error occured
fun1(false).then(
    (successMessage) => {
        console.log('4 - fun1 call - ' + JSON.stringify(successMessage));
        return fun1(false);
    }
).then(
    (successMessage) => {
        console.log('5 - fun1 call - ' + JSON.stringify(successMessage));
    }
).catch(
    () => {
        console.log("7 - Error occured");
    }
);
