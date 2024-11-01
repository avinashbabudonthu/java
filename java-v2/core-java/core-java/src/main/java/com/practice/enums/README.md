### [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Enum issue
* Error
```
Exception in thread "main" java.lang.ExceptionInInitializerError
	at com.test.EnumIssue.<clinit>(EnumIssue.java:9)
Caused by: java.lang.NullPointerException: Cannot invoke "[Lcom.test.EnumIssue$Employee;.clone()" because "com.test.EnumIssue$Employee.$VALUES" is null
	at com.test.EnumIssue$Employee.values(EnumIssue.java:14)
	at com.test.EnumIssue$Employee.<init>(EnumIssue.java:49)
	at com.test.EnumIssue$Employee.<clinit>(EnumIssue.java:15)
	... 1 more
```
* If we declare non-static variables inside enum then we will get this error
* Refer [EnumIssue.java](EnumIssue.java)
------
### [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)