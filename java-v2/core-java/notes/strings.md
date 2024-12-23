# String Notes
------
# String Basics
* class in `java.lang` package
* String is immutable means once String object is created it cannot be changed
* Any operations performed on String will create new String object with new character sequence
------
# String classes to refer
* StringBuffer
	* All methods are `synchronized`
* StringBuilder
	* All methods are `non synchronized`
* StringJoiner
	* StringJoiner is used to construct  
		* Sequence of characters separated by a delimiter 
		* Optionally starting with a supplied prefix and ending with a supplied suffix
------	
# String formatter
Format Specifier    | Description   | Output
--------------------|---------------|----------------------
%a | floating point (except BigDecimal) | Returns Hex output of floating point number
%b | Any type  | "true" if non-null, "false" if null    
%c | character | Unicode character
%d | integer (incl. byte, short, int, long, bigint) | Decimal Integer
%e or %eE | floating point | decimal number in scientific notation
%f | floating point | decimal number
%g | floating point | decimal number, possibly in scientific notation depending on the precision and value
%h | any type | Hex String of value from hashCode() method
%n | none | Platform-specific line separator
%o | integer (incl. byte, short, int, long, bigint) | Octal number
%s | any type | String value
%t | Date/Time (incl. long, Calendar, Date and TemporalAccessor) | %t is the prefix for Date/Time conversions
%x or %xX | integer (incl. byte, short, int, long, bigint) | Hex string
0 | Zero padding | Zero padding
\- | Left justify | Left justify
, | group |
space | leave space for positive number |
\+ | always show sign |
\( | enclose negative values in parenthesis |
------
# Remove HTML tags from String
* A String is a final class in Java and it is immutable, it means that we cannot change the object itself, but we can change the reference to the object
* The HTML tags can be removed from a given string by using replaceAll() method of String class
* We can remove the HTML tags from a given string by using a regular expression
* After removing the HTML tags from a string, it will return a string as normal text
* Refer `removeHTMLFromString` method in [String Examples](../basics/src/main/java/com/java/strings/StringsPractice.java)
------
# Examples
* [String Examples](../core-java/src/main/java/com/practice/java/lang/StringTest.java)
* [String Joiner Examples](../core-java/src/main/java/com/practice/java/util/StringJoinerTest.java)