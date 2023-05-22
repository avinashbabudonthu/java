# Notes
* One application wide log manager
* log manager manages log system configuration
* manage objects that are logging
* Log manager class - `LogManager`
* We will have one global instance of `LogManager` class
* We can access `LogManager` instance using `LogManager.getLogManager`
* Logger instance
    * Provides methods that we use for logging
    * Logger logger = logManager.getLogger()
    * Each logger instance is named
    * Global logger name is available in Logger class `Logger.GLOBAL_LOGGER_NAME`. We can use that also
    * Create Logger instance as **private static final** at class level
    ```
    private static final Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    ```
    * Write logs as follows
    ```
    logger.log(Level.INFO, "welcome to java util logging");
	logger.info("welcome to Logger.info");
    ```

## Logging Levels
* Each log entry is associated with level
* Each logger has capture level
    * Use **setLevel** method
    ```
    setLevel(Level.INFO)
    ```
    * Once capture level is set logger will ignore any entry that is below that level
* Each level has numeric value
    * 7 basic log levels
    * 2 specific levels for Logger
    * Can define custom log level but not preferable

Level            | Numeric Value   | Description
---------------  | --------------- | ---------------
SEVERE           | 1000            | Serious Failure
WARNING          | 900             | Warning
INFO             | 800             | Information
CONFIG           | 700             | Configuration information like database connection etc
FINE             | 500             | General developer needed information
FINER            | 400             | Detailed developer needed information
FINEST           | 300             | Specialized developer needed information
OFF              |                 | logging off
ALL              |                 | log every thing

## Log methods
* Simple **log** method
```
logger.log(Level.FINE, "fine log");
```
* Level convinience methods
```
logger.info("welcome to Logger.info");
```

Method          | Level
--------------- | ---------------
severe          | Level.SEVERE
warning         | Level.WARNING
info            | Level.INFO
config          | Level.CONFIG
fine            | Level.FINE
finer           | Level.FINER
finest          | Level.FINEST

* Precise log methods
    * Regular `log` method will look into call stack to get class name, method name. But sometimes logger will get those names wrong. So we need to pass class name, method names to log method. For that we have to use `logp`
    ```
    logger.logp(Level.INFO, "com.test.MyClass", "myMethod", "My Log message");
    ```
* Precise convinience methods
    * Logging common method actions
    * Logs predefined messages
    * Always logged with level Level.FINER

Method      | Message
------------|------------
entering    | ENTRY
exiting     | RETURN

```
logger.entering("com.test.MyClass", "myMethod");
logger.exiting("com.test.MyClass", "myMethod");
```
* Parameterized message methods
    * log, logp supports message parameters
    * Use positional substitutions
    * Zero based index within brackers **{index}**
    ```
    logger.log(Level.INFO, "welcome to {0}", "Java");
    logger.log(Level.INFO, "welcome to {0}, {1}", new Object[]{"Java", "Logging"});
    logger.entering("com.test.MyClass", "myMethod", new Object[]{"Java", "Logging"});
    logger.exiting("com.test.MyClass", "myMethod", new Object[]{"Java", "Logging"});
    ```
	
## Logger Components
* Logger
	* Accept app calls
* Handler
	* Publishes log information
	* Logger can have one or more handlers
	* 1 logger can have multiple handlers
	* Can have setLevel. So we can set one level to one handler and another level to another handler
* Formatter
	* Formats log info
	* Each handler has 1 formatter
	
### Flow between above 3 components
* App writes log to Logger as `LogRecord`
* LogRecord is given to Handler
* Handler passes LogRecord to Formatter
* Formatter formats the LogRecord and send back to Handler
* Handler publishes the LogRecord to console, log file etc
