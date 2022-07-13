## Formats
Format            					| Description
------------------------------------| ------------------------------------
%d{yyyy-MM-dd HH:mm:ss}           	| Date and time format, refer to SimpleDateFormat JavaDoc           
%-5p								| The logging priority, like DEBUG or ERROR. The -5 is optional, for the pretty print format
%c{1} (or) %C{1} 					| The logging name we set via getLogger(). Prints only class name
%c (or) %C							| 	The logging name we set via getLogger(). Prints fully packaged class name
%L									|	The line number from where the logging request
%m%n								| The message to log and line break
%M									| To get method name in log. logging with location is 4 - 20 times slower than without location

## Priorities
* If priority is defined in log4j.properties, only the same or above priority message will be logged
```
package org.apache.log4j;

public class Priority {

  public final static int OFF_INT = Integer.MAX_VALUE;
  public final static int FATAL_INT = 50000;
  public final static int ERROR_INT = 40000;
  public final static int WARN_INT  = 30000;
  public final static int INFO_INT  = 20000;
  public final static int DEBUG_INT = 10000;
  public final static int ALL_INT = Integer.MIN_VALUE;
  ----
}
```