function log(message) {
    console.log(message);
}

// to export log function to out side this file
// log function is exposed as `printToConsole`
module.exports = {
    printToConsole: log
}