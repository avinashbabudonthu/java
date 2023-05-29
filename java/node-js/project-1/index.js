const { printToConsole } = require('./logger');
const logger = require('./logger'); // to call printConsole from logger.js file
const _ = require('underscore');

// calling log function in logger.js
// output - Message 1
logger.printToConsole("Message 1");

// first function from underscore
console.log(_.first([5,8,6,7,2,8,3,9])); // 5