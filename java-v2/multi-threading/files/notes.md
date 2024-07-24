### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Multi threading
* Responsiveness is achieved by concurrency
* Performance is achieved by parallelism

# Each Thread will have
* Stack: Memory where local variables are stored and passed to functions
* Instruction Pointer: Address of the next instruction to execute
* Shares Files, Heap, code

# Contex switch

# Performance in multi threading
* Latency: Time to completion of task. Measured in time units
* Throughput: Number of tasks completed in a given period of time. Measured in tasks per time unit

# Idea number of threads to create?
* # threads == # cores is optimal only if all threads are runnable and can run without interruption (ni IO, blocking calls, sleep etc)

# Hyperthreads
* Virtual cores will be created
* Threads will run in Virtual cores similar to actual physical cores. But performance won't as best as physical cores because underlying hardware is only one
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)