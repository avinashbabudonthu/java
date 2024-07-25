### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Multi threading
* Responsiveness is achieved by concurrency
* Performance is achieved by parallelism
------
# Each Thread will have
* Stack: Memory where local variables are stored and passed to functions
* Instruction Pointer: Address of the next instruction to execute
* Shares Files, Heap, code
------
# Performance in multi threading
* Latency: Time to complete one task. Measured in time units
* Throughput: Number of tasks completed in a given period of time. Measured in tasks per time unit
------
# Ideal number of threads to create?
* (number of threads == number of cores) is optimal only if all threads are runnable and can run without interruption (no IO, blocking calls, sleep etc)
------
# Hyperthreads
* Virtual cores will be created
* Threads will run in Virtual cores similar to actual physical cores. But performance won't as best as physical cores because underlying hardware is only one
------
# Race Condition
* Condition when multiple threads are accessing shared resource
* At least one thread is modifyiing the resource
* Timing of threads scheduling may cause incorrect results
* Problem is non atomic operations performed on shared resource

# Race condition solution
* Identifying critical section where race condition is happening
* Protecting critical section with synchronized block

# Rule of Thumb
* Every shared variable (modified by at least one thread) should be either
	* Guarded by synchronized block (or any type of lock)
	(or)
	* Declared `volatile`
------
# Data Race


------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)