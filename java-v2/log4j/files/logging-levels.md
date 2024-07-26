### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Logging Levels
* The org.apache.log4j.Level levels. You can also define your custom levels by sub-classing the Level class
* ALL - All levels including custom levels.
* DEBUG - Designates fine-grained informational events that are most useful to debug an application.
* INFO - Designates informational messages that highlight the progress of the application at coarse-grained level.
* WARN - Designates potentially harmful situations.
* ERROR - Designates error events that might still allow the application to continue running.
* FATAL - Designates very severe error events that will presumably lead the application to abort.
* OFF - The highest possible rank and is intended to turn off logging.
* TRACE - Designates finer-grained informational events than the DEBUG.
------
# Order of log levels
```
ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
```
* If `ALL` is given then all levels are logged
* If `DEBUG` is given then DEBUG to all above levels are logged
* Other levels also same as DEBUG
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)