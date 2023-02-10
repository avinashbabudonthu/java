# Single Repo For All Java Examples, topic wise in Alphabetical Order
------
# Index
* [Core Java](#core-java)
* [Gradle](#gradle)
* [Maven](#maven)
* [UML](#uml)
------
# [Core Java](core-java)
* [Materials](core-java/materials.md)
* [Notes](core-java/notes/basics.md)
* [Environment Variables vs System properties (or VM Arguments) vs Program arguments (or Command line arguments) | Java](core-java/variables-arguments.md)
* [Integer class Practice](core-java/basics/src/test/java/com/java/IntegerPractice.java)
* [Runtime class - ShutdownHook Notes](core-java/notes/runtime.md#addshutdownhook)
* [Runtime class - ShutdownHook Example 1](core-java/basics/src/main/java/com/java/lang/ShutdownHook1.java)
* [Runtime class - ShutdownHook Example 2](core-java/basics/src/main/java/com/java/lang/ShutdownHook2.java)
* [Runtime.Version class - Runtime major minor build versions etc](core-java/basics/src/main/java/com/java/lang/RuntimeVersionPractice.java)
* [Optional class - Notes](core-java/notes/optional.md)
* [Optional class - Code Examples](core-java/java-8/java8/src/main/java/com/java/util/OptionalPractice.java)
* [Locale](core-java/internationalization/src/test/java/com/internationalization/LocalePractice.java)
	* localObjectByCountry
	* createLocalObject
	* localObjectLanguageWise
* [ResourceBundle](core-java/internationalization/src/test/java/com/resource/bundle/ResourceBundlePractice.java)
	* listResourceBundle
		* [MyListResourceBundle](core-java/internationalization/src/test/java/com/resource/bundle/MyListResourceBundle.java)
		* [MyListResourceBundle_telugu](core-java/internationalization/src/test/java/com/resource/bundle/MyListResourceBundle_telugu.java)
	* propertyResourceBundle
		* [labels.properties](core-java/internationalization/src/main/resources/labels.properties)
		* [labels_telugu.properties](core-java/internationalization/src/main/resources/labels_telugu.properties)
* [Base64](core-java/basics/src/test/java/com/java/util/Base64EncodeDecodePractice.java)
	* encode
	* decode
	* usernameAndPassword
* [HashCodes](core-java/basics/src/test/java/com/java/util/HashCodes.java)
	* hashCodeFromArray
	* longHashCode
	* floatHashCode
* [java.math.BigDecimal](core-java/basics/src/main/java/com/java/math/BigDecimalPractice.java)
* [DecimalFormat](core-java/internationalization/src/test/java/com/internationalization/DecimalFormatPractice.java)
	* createDecimalFormatObject
	* applyNewPatterns
	* formatNumber
	* formatNumberSpecificToLocale
	* customDecimalFormats
	* groupingDigits
* [NumberFormat](core-java/internationalization/src/test/java/com/internationalization/NumberLocalePractice.java)
	* createNumberFormatObject
	* formatNumber
	* formatCurrency
	* formatPercentage
	* minMaxNoOfDigits
	* roundingNumbers
	* parseNumber
* [UUID Generator](core-java/basics/src/test/java/com/java/util/RequestUUIDGenerator.java)
* [Create Basic Auth Header](core-java/basics/src/test/java/com/java/util/Utils.java) - createBasicAuthHeader
* [Generate 10 Digit Random Number](core-java/basics/src/test/java/com/java/util/Utils.java) - generate10DigitRandomNumber
* [Generate N Digit Random Number](core-java/basics/src/test/java/com/java/util/Utils.java) - generateNDigitRandomNumber
* [Generate Random Number in Range](core-java/basics/src/test/java/com/java/util/Utils.java) - generateRandomNumberInRange
* [Generate N Digit Random Number in Range](core-java/basics/src/test/java/com/java/util/Utils.java) - generateNDigitRandomNumberInRange
* [Generate random password](utils/generate-random-password.md)
* [Reverse the number](utils/utils.md#reverse-the-number)

# File IO
* [FileIOPractice](core-java/basics/src/main/java/com/java/io/FileIOPractice.java)
* [java.io.RandomAccessFile](core-java/basics/src/main/java/com/java/io/RandomAccessFilePractice.java)
* [Read Input From Keyboard](core-java/basics/src/main/java/com/java/io/ReadInputFromKeyboard.java)

# [Annotations](core-java/annotations)
* [Notes](core-java/notes/annotations.md)
* [Java Docs](https://docs.oracle.com/javase/tutorial/java/annotations/index.html)
* Custom annotation
	* [Custom annotation](core-java/annotations/src/main/java/com/custom/annotations)
	* [TableTest](core-java/annotations/src/test/java/com/custom/annotations/TableTest.java)
* Repeating annotations
	* [Repeating annotations](core-java/annotations/src/main/java/com/repeating/annotation)
	* [BookTest](core-java/annotations/src/test/java/com/repeating/annotation/BookTest.java)

# Strings
* [Notes](core-java/notes/strings.md)
* [String Examples](core-java/basics/src/main/java/com/java/strings/StringsPractice.java)
	* Create String - createString
	* getbyteArrayFromString
	* getAsciValueOfCharsInString
	* convertByteArrayToString
	* divideString
	* stringToCharArray
	* convertCase
	* capitalizeFirstChar
	* stringShift
	* printAllSubStringsOfSpecifiedLength
	* sortStringsInSentnceByLength
	* replaceAll
	* removeSpacesInString
	* lastNCharactersOfString
	* split
	* splitByPipe
	* subString
	* stringToEBCDIC
	* stringToBytes
	* removeHTMLFromString
	* stringToInputStream
	* generateExcelCellNames
	* inputStreamToString
	* rotateString
	* Clob to String conversion - clobToString
* [String format](core-java/basics/src/main/java/com/java/strings/StringFormatPractice.java)
	* String format conventions and flags - stringFormatConventionsAndFlags
	* String format - stringFormat
	* To use (%) percentage symbol in String - format2
* [String Joiner](core-java/basics/src/main/java/com/java/strings/StringJoinerPractice.java)
	* Comma seprated String - commaSeparatedString
	* String join - stringJoin
	* List of Employee objects to comma separated first names - listOfEmployeeToCommaSeparatedFirstName
	* merge 2 string joiners - merge
	* String joiner length - length

# [Collections](core-java/collections)
* [Notes](core-java/notes/collections.md)
* [Java Doc Notes](https://docs.oracle.com/javase/tutorial/collections/index.html)
* [Examples](#javautil-package)
* [Collections.synchronizedMap vs. ConcurrentHashMap](core-java/collections/java-synchronizedmap-vs-concurrenthashmap.md)
* List Examples
	* [ArrayList](core-java/collections/src/test/java/com/list/ArrayListPractice.java)
	* [LinkedList](core-java/collections/src/test/java/com/list/LinkedListPractice.java)
	* [CopyOnWriteArrayListPractice](core-java/collections/src/test/java/com/list/CopyOnWriteArrayListPractice.java)
* Set Examples
	* [HashSet](core-java/collections/src/test/java/com/set/HashSetPractice.java)
	* [LinkedHashSet](core-java/collections/src/test/java/com/set/LinkedHashSetPractice.java)
	* [TreeSet](core-java/collections/src/test/java/com/set/TreeSetPractice.java)
	* [EnumSet](core-java/collections/src/test/java/com/set/EnumSetPractice.java)
	* [CopyOnWriteArraySetPractice](core-java/collections/src/test/java/com/set/CopyOnWriteArraySetPractice.java)
	* [ConcurrentSkipListSetPractice](core-java/collections/src/test/java/com/set/ConcurrentSkipListSetPractice.java)
* Map Examples
	* [HashMap](core-java/collections/src/test/java/com/map/HashMapPractice.java)
	* [LinkedHashMap](core-java/collections/src/test/java/com/map/LinkedHashMapPractice.java)
	* [TreeMap](core-java/collections/src/test/java/com/map/TreeMapPractice.java)
	* [ConcurrentHashMap](core-java/collections/src/test/java/com/map/ConcurrentHashMapPractice.java)
	* [ConcurrentSkipListMap](core-java/collections/src/test/java/com/map/ConcurrentSkipListMapPractice.java)
	* [EnumMap](core-java/collections/src/test/java/com/map/EnumMapPractice.java)
	* [IdentityHashMap](core-java/collections/src/test/java/com/map/IdentityHashMapPractice.java)
	* [MapStreams](core-java/collections/src/test/java/com/map/MapStreamsPractice.java)
	* [WeakHashMap](core-java/collections/src/test/java/com/map/WeakHashMapPractice.java)
	* [Collections.synchronizedMap vs. ConcurrentHashMap](core-java/collections/java-synchronizedmap-vs-concurrenthashmap.md)
* Queue Examples
	* [PriorityQueuePractice](core-java/collections/src/test/java/com/queue/PriorityQueuePractice.java)
* Dequeue Examples
	* [ArrayDeQueuePractice](core-java/collections/src/test/java/com/dequeue/ArrayDeQueuePractice.java)
* [Arrays](core-java/collections/src/test/java/com/util/ArraysPractice.java)
	* parallelSort
	* parallelSetAll
	* setAll
	* parallelPrefix
	* deepEquals
	* hashCode
	* deepHashCode
	* fill
	* deepToString

# Serialization Examples
* [Notes](core-java/notes/serialization.md)
* [Model classes](core-java/basics/src/main/java/com/serialization)
* [Serialize](core-java/basics/src/test/java/com/serialization/Serialize.java)
* [DeSerialize](core-java/basics/src/test/java/com/serialization/DeSerialize.java)

# [Date Practice](core-java/date-practice)
## Date format conventions
* java.util.Date to String conversion - java.text.DateFormat.format
* String to java.util.Date conversion - java.text.DateFormat.parse
* String to java.time.LocalDate conversion - java.time.LocalDate.parse(stringDate, java.time.format.DateTimeFormatter.ofPattern(input-date-format))
* MM - Month in Number format
* MMM - Month in English in short form
* MMMM - Month in English in full form
* dd - Date in 2 digits
* d - Date in single digit
* E (or) EEE - Day in shot form
* EEEE - Day in full form
* yyyy - Four digit year
* HH - 24 hours timeline
* hh - 12 hours timeline
* mm - Minutes
* ss - Seconds
* SSS - Milli Seconds
* a	- AM/PM
* Z - Time Zone
## Examples
* [Clock](core-java/date-practice/src/test/java/com/date/api/practice/ClockPractice.java)
	* createClock
	* clockMethods
* [Conversion from class to class](core-java/date-practice/src/test/java/com/date/api/practice/ConversionFromClassToClass.java)
	* localDateToGregorianCalendar
	* localDateToXmlGregorianCalendar
	* utilDateToXmlGregorianCalendar
	* xmlGregorianCalendarToUtilDate
	* xmlGregorianCalendarToGregorianCalendar
	* timeInMillisToGregorian
* [Date Utils](core-java/date-practice/src/test/java/com/date/api/practice/DateUtils.java)
	* convertDateFormat1
	* getDayOfWeek
* [Duration](core-java/date-practice/src/test/java/com/date/api/practice/DurationPractice.java)
	* durationBetweenTwoDates
* [Instant](core-java/date-practice/src/test/java/com/date/api/practice/InstantPractice.java)
	* createInstant
	* instantToOffsetDateTime
	* instantToUtilDate
* [LocateDate](core-java/date-practice/src/test/java/com/date/api/practice/LocalDatePractice.java)
	* createLocalDateWithCurrentDate
	* createLocalDate
	* addDayWeekMonth
	* nextSunday
	* nextMonthSecondSaturday
	* convertLocalDateToUtilDate
	* convertStringToLocalDate
* [LocalDateTime](core-java/date-practice/src/test/java/com/date/api/practice/LocalDateTimePractice.java)
	* createLocalDateTime
	* convertLocalDateTimeToUtilDate
	* convertLocalDateTimeToZonedDateTime
	* convertLocalDateTimeToStringTimeStamp
	* localDateTimeToOffsetDateTime
* [LocalTime](core-java/date-practice/src/test/java/com/date/api/practice/LocalTimePractice.java)
	* createLocalTime
* [OffsetDateTime](core-java/date-practice/src/test/java/com/date/api/practice/OffsetDateTimePractice.java)
	* create
	* offsetDateTimeToLocalDateTime
	* offsetDateTimeToLocalDate
	* offsetDateTimeToLocalTime
	* offsetDateTimeToZonedDateTime
	* offsetDateTimeToInstant
	* offsetDateTimeToOffsetTime
	* offsetDateTimeYearMonthDay
	* offsetDateTimeHourMinuteSecond
	* addYearMonthEtc
	* subtractYearMonthEtc
	* compare
	* stringToOffsetDateTime
	* offsetDateTimeToString
	* convertUtilDateToOffsetDateTime
	* covertOffsetDateTimeToUtilDate
* [Util Date](core-java/date-practice/src/test/java/com/date/api/practice/UtilDate.java)
	* convertStringToDate
	* convertDateToString
	* convertDateToLocalDateTime
	* convertUtilDateToLocalDate
	* convertUtilDateToLocalTime
	* convertUtilDateToZonedDateTime
	* before
	* after
	* utilDateToTimeStamp
	* timeStampToUtilDate
* [ZoneDateTime](core-java/date-practice/src/test/java/com/date/api/practice/ZonedDateTimePractice.java)
	* createZonedDateTime
	* convertZonedDateTimeToUtilDate
	* zonedDateTimeToOffsetDateTime

# Enum
* [Enum Basics](core-java/basics/src/test/java/com/enums/EnumPractice.java)
	* [DaysEnum](core-java/basics/src/main/java/com/enums/DaysEnum.java)
	* [DaysEnum2](core-java/basics/src/main/java/com/enums/DaysEnum2.java)
	* [EnumImpl](core-java/basics/src/main/java/com/enums/EnumImpl.java)
	* [EnumMethods](core-java/basics/src/main/java/com/enums/EnumMethods.java)
	* [IEnum](core-java/basics/src/main/java/com/enums/IEnum.java)
	* accessEnumValue
	* iterateEnum
	* enumInIf
	* enumInSwitch
	* iterateEnumWithArgumentedConstructor
	* enumToString
	* valueOf
	* enumMethods
	* enumImplementingInterface
	* enumSet
	* enumMap
* [Enum Lookup](core-java/basics/src/test/java/com/enums/lookup/EnumLookUp.java)
	* [CardSuitEnum](core-java/basics/src/main/java/com/enums/lookup/CardSuitEnum.java)
	* lookupMap

# Multi threading
* [Materials](core-java/multi-threading/materials.md)
* [Notes](core-java/notes/multi-threading.md)

# Generics
* [Notes](core-java/notes/generics.md)
* [Java Docs Notes](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
* [Java Docs Extra Notes](https://docs.oracle.com/javase/tutorial/extra/generics/index.html)

# Java 8 Examples
* [Notes](core-java/notes/java-8-notes.md)
* [Interfaces](core-java/java-8/java8/src/main/java/com/interfaces)
* [Functional Interface](core-java/java-8/java8/src/main/java/com/functional/interfaces)
* [Constructor References](core-java/java-8/java8/src/main/java/com/constructor/references/FunctionalInterface1.java)
* [Lambda Expressions](core-java/java-8/java8/src/main/java/com/lambda/expressions)
* [Method Reference](core-java/java-8/java8/src/main/java/com/method/references)
* [BiFunctional Interface](core-java/java-8/java8/src/main/java/com/java/util/function/BiFunctionPractice.java)
* [Supplier](core-java/java-8/java8/src/main/java/com/java/util/function/SupplierPractice.java)

# [Java 9](core-java/java-9)
* [Notes](core-java/java-9/README.md)
* [Notes](core-java/java-9/notes.md)

# [Java 11](core-java/java-11)
* [Materials](core-java/java-11/materials.md)
* [Notes](core-java/java-11/notes.md)
* [NewFeaturesPractice](core-java/java-11/java-11/src/main/java/com/java/NewFeaturesPractice.java)

# [Java 17](core-java/java-17)
* [Materials](core-java/java-17/materials.md)

# Reactive Programming
* [Notes](core-java/notes/reactive-programming.md)
------
# [Maven](maven)
* [Materials](maven/materials.md)
* [Installation](maven/installation.md)
* [Notes](maven/notes.md)
* [Commands](maven/commands.md)
* [Sample pom xml file](maven/sample_pom.xml)
* [Maven install plugin to install any jar automatically before building our war/jar](maven/notes.md#maven-install-plugin)
* [repositories tag](maven/notes.md#repositories-tag)
* [Maven Push to remote repository - distributionManagement tag](maven/notes.md#distributionmanagement-tag)
* [Maven compiler plugin](maven/notes.md#maven-compile-plugin)
* [Maven Spring Boot Plugin](maven/notes.md#maven-spring-boot-plugin)
* [Maven Execute Exec Plugin](maven/notes.md#maven-execute-exec-plugin)
* [Skip Test Cases](maven/notes.md#skip-test-cases)
* [Maven Surefire Plugin](maven/notes.md#maven-surefire-plugin)
* [Maven war plugin](maven/notes.md#maven-war-plugin)
* [exec-maven-plugin](maven/notes.md#exec-maven-plugin)
* [Maven dependency scopes](maven/notes.md#Maven-dependency-scopes)
* [Maven version plugin](maven/notes.md#Maven-version-plugin)
------
# [Gradle](gradle)
* [Materials](gradle/materials.md)
* [Installation](gradle/installation.md)
* [Commands](gradle/commands.md)
* [Plugins](gradle/plugins.md)
* [Properties](gradle/properties.md)
* [Upload archives to remote repository](gradle/upload-archives-to-remote-repository.md)
------
# [UML](uml)
* [Notes](uml/notes.md)