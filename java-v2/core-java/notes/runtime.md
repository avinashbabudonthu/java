# addShutdownHook
* The java.lang.Runtime.addShutdownHook(Thread hook) method registers a new virtual-machine shutdown hook.The Java virtual machine shuts down in response to two kinds of events
  * The program exits normally, when the last non-daemon thread exits or when the exit (equivalently, System.exit) method is invoked, or
  * The virtual machine is terminated in response to a user interrupt, such as typing ^C, or a system-wide event, such as user logoff or system shutdown.
* A shutdown hook is simply an initialized but unstarted thread. When the virtual machine begins its shutdown sequence it will start all registered shutdown hooks in some unspecified order and let them run concurrently. When all the hooks have finished it will then run all uninvoked finalizers if finalization-on-exit has been enabled. Finally, the virtual machine will halt. Note that daemon threads will continue to run during the shutdown sequence, as will non-daemon threads if shutdown was initiated by invoking the exit method.
------
# Declaration
* Following is the declaration for java.lang.Runtime.addShutdownHook() method
```
public void addShutdownHook(Thread hook)
```
------
# Examples
* [ShutdownHook Example 1](../../../java/core-java/basics/src/main/java/com/java/lang/ShutdownHook1.java)
* [ShutdownHook Example 2](../../../java/core-java/basics/src/main/java/com/java/lang/ShutdownHook2.java)
* [Runtime Version](../../../java/core-java/basics/src/main/java/com/java/lang/RuntimeVersionPractice.java)