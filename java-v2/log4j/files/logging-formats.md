### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Formats
* Some logging formats. Refer - https://logging.apache.org/log4j/2.x/manual/layouts.html#PatternLayout

Format            					| Description
------------------------------------| ------------------------------------
%d{yyyy-MM-dd HH:mm:ss}           	| Date and time format, refer to SimpleDateFormat JavaDoc           
%-5p								| The logging priority, like DEBUG or ERROR. The -5 is optional, for the pretty print format
%c{1} (or) %C{1} 					| The logging name we set via getLogger(). Prints only class name
%c (or) %C							| 	The logging name we set via getLogger(). Prints fully packaged class name
%L									|	The line number from where the logging request
%m%n								| The message to log and line break
%M									| To get method name in log. logging with location is 4 - 20 times slower than without location
%t                  | Current thread name
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)