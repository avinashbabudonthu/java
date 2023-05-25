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

fun1(true).then(
    (successMessage) => console.log(successMessage)
);