package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.*;

@Slf4j
public class ThreadPractice {

    /**
     * inside thread1 run method
     * inside thread3 run method
     * inside thread2 run method
     * inside thread4 run method
     * inside thread5 run method
     * inside thread7 run method, name=worker thread 7
     * inside Thread1.run method, name=Thread-6, id=19
     */
    @DisplayName("Create thread")
    @Test
    void createThread() {
        // with Runnable
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("inside thread1 run method");
            }
        });
        thread1.start();

        // with lambda
        Thread thread2 = new Thread(() -> {
            log.info("inside thread2 run method");
        });
        thread2.start();

        // anonymous inner class
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                log.info("inside thread3 run method");
            }
        };
        thread3.start();

        // thread4 start thread immediately after creation
        new Thread(() -> {
            log.info("inside thread4 run method");
        }).start();

        // thread5
        new Thread(() -> log.info("inside thread5 run method")).start();

        // By extends java.lang.Thread
        Thread thread6 = new Thread6();
        thread6.start();

        // Thread create with Runnable and name
        Runnable runnable = () -> log.info("inside thread7 run method, name={}", Thread.currentThread().getName());
        Thread thread7 = new Thread(runnable, "worker thread 7");
        thread7.start();
    }

    /**
     * Before executing thread. id=1, name=main
     * After executing thread. id=1, name=main
     * inside thread. id=14, name=Thread-1
     */
    @DisplayName("Print thread id name")
    @Test
    void threadIdAndName() {
        log.info("Before executing thread. id={}, name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            log.info("inside thread. id={}, name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
        });
        log.info("After executing thread. id={}, name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
        thread.start();
    }

    /**
     * output -
     * Before execution
     * inside thread run method, name=Thread-1
     * After execution. Time-taken=5007
     */
    @DisplayName("Thread sleep method")
    @Test
    void sleep() throws InterruptedException {
        log.info("Before execution");
        long startTime = System.currentTimeMillis();
        // sleep method takes milli seconds
        new Thread(() -> {
            log.info("inside thread run method, name={}", Thread.currentThread().getName());
        }).start();

        Thread.sleep(1000 * 5);

        long endTime = System.currentTimeMillis();
        log.info("After execution. Time-taken={}", (endTime - startTime));
    }

    /**
     * output:
     * inside thread run method. name=worker thread 1
     */
    @DisplayName("Set name to thread")
    @Test
    void setThreadName() {
        Thread thread = new Thread(() -> {
            log.info("inside thread run method. name={}", Thread.currentThread().getName());
        });
        thread.setName("worker thread 1");
        thread.start();
    }

    /**
     * output:
     * thread name=worker thread 1, priority=10
     */
    @Test
    void setPriority() {
        Thread thread = new Thread(() -> {
            log.info("thread name={}, priority={}", Thread.currentThread().getName(), Thread.currentThread().getPriority());
        });
        thread.setName("worker thread 1");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    /**
     * output:
     * Critical exception occurred in Misbehave worker thread 1. Error is Intentional exception
     */
    @Test
    void exceptionHandling() {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional exception");
        });

        // set exception handling
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.info("Critical exception occurred in {}. Error is {}", t.getName(), e.getMessage());
            }
        });

        thread.setName("Misbehave worker thread 1");

        thread.start();
    }

    /**
     * If we call start() method 2 times then IllegalStateException will be thrown
     * <p>
     * output:
     * inside thread run method
     * <p>
     * java.lang.IllegalThreadStateException
     * at java.lang.Thread.start(Thread.java:708)
     * at com.java.ThreadPractice.illegalStateException(ThreadPractice.java:157)
     */
    @DisplayName("Illegal state exception")
    @Test
    void illegalStateException() {
        Thread thread = new Thread(() -> log.info("inside thread run method"));
        thread.start();
        // thread.start(); // throws IllegalStateException if this line is uncommented
    }

    /**
     * If interrupt() method is called any thread then InterruptedException is thrown.
     * {@link BlockingThread} class is sleeping for 500,000 milli seconds, so interrupt() method called
     * on this thread, so this throws InterruptedException which is handled in catch block of
     * {@link BlockingThread#run()} method
     * <p>
     * output:
     * Starting BlockingThread, name=main
     * Started BlockingThread, name=main
     * Exiting BlockingThread, name=worker thread 1
     * <p>
     * java.lang.InterruptedException: sleep interrupted
     * at java.lang.Thread.sleep(Native Method)
     */
    @DisplayName("Thread.interrupt method")
    @Test
    void interrupt() {
        log.info("Starting BlockingThread, name={}", Thread.currentThread().getName());
        Thread thread = new Thread(new BlockingThread(), "worker thread 1");
        thread.start();
        log.info("Started BlockingThread, name={}", Thread.currentThread().getName());
        thread.interrupt();
    }

    @DisplayName("join method")
    @Test
    void joinMethod() throws InterruptedException {
        List<Long> numbers = Arrays.asList(0L, 1234L, 2345L, 23L, 3456L);
        List<FactorialThread> threads = new ArrayList<>();

        for (Long number : numbers) {
            threads.add(new FactorialThread(number));
        }

        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        for (Thread thread : threads) {
            // thread.join(); // this call will make current thread to wait until all threads are finished
            // thread.join(1000 * 2); // current thread waits maximum 2 seconds
            thread.join(1000 * 2);
        }

        for (int i = 0; i < numbers.size(); i++) {
            FactorialThread thread = threads.get(i);
            if (thread.getIsFinished()) {
                log.info("factorial of number={} is {}", numbers.get(i), thread.getResult());
            } else {
                log.info("factorial of number={} is still in progress", numbers.get(i));
            }
        }
    }

    /**
     * Create java.util.concurrent.ExecutorService
     *
     * output:
     * executorService1=java.util.concurrent.Executors$FinalizableDelegatedExecutorService@710726a3
     * executorService2=java.util.concurrent.ThreadPoolExecutor@78186a70[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
     * executorService3=java.util.concurrent.ScheduledThreadPoolExecutor@306279ee[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
     */
    @DisplayName("Create ExecutorService")
    @Test
    void createExecutorService(){
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        log.info("executorService1={}", executorService1);
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        log.info("executorService2={}", executorService2);
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
        log.info("executorService3={}", executorService3);
    }

    /**
     * Delegate tasks for execution to java.util.concurrent.ExecutorService
     *
     * output:
     * Thread2, name=pool-2-thread-1
     * Thread1, name=pool-1-thread-1
     * result=null
     * future1Result=Hello World
     */
    @Test
    void executorServiceMethods() {
        // execute(Runnable)
        Runnable thread1 = () -> log.info("Thread1, name={}", Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(10); // creates thread pool with 10 threads executing tasks
        executorService.execute(thread1); // Runnable to be executed by one of the threads in ExecutorService
        executorService.shutdown();

        // submit(Runnable)
        Runnable runnable2 = () -> log.info("Thread2, name={}", Thread.currentThread().getName());
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        Future<?> future = executorService2.submit(runnable2);
        try {
            Object result = future.get(); //returns null if the task has finished correctly
            log.info("result={}", result);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception while getting task finish status", e);
        }

        // submit(Callable)
        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        };
        ExecutorService executorService3 = Executors.newFixedThreadPool(5);
        Future<String> future1 = executorService3.submit(callable1);
        try {
            log.info("future1Result={}", future1.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception while getting result", e);
        }

        // invokeAny()
        executorServiceInvokeAny();

        // invokeAll()
        executorServiceInvokeAll();
    }

    /**
     * The invokeAny() method takes a collection of Callable objects, or subinterfaces of Callable. Invoking this method does not return a Future, but returns the result of one of the Callable objects. You have no guarantee about which of the Callable's results you get. Just one of the ones that finish.
     * If one Callable finishes, so that a result is returned from invokeAny(), then the rest of the Callable instances are cancelled.
     * If one of the tasks complete (or throws an exception), the rest of the Callable's are cancelled.
     *
     * output: execution 1
     * Inside task1
     * Inside task2
     * Inside task3
     * result=Task 2
     *
     * output: execution 2
     * Inside task1
     * Inside task2
     * Inside task3
     * result=Task 1
     */
    @DisplayName("ExecutorService invokeAny method")
    @Test
    void executorServiceInvokeAny(){
        Callable<String> task1 = () -> {
            log.info("Inside task1");
            return "Task 1";
        };

        Callable<String> task2 = () -> {
            log.info("Inside task2");
            return "Task 2";
        };

        Callable<String> task3 = () -> {
            log.info("Inside task3");
            return "Task 3";
        };

        Set<Callable<String>> callableSet = new HashSet<>();
        callableSet.add(task1);
        callableSet.add(task2);
        callableSet.add(task3);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            String result = executorService.invokeAny(callableSet);
            log.info("result={}", result);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception invokeAny", e);
        }
    }

    /**
     * The invokeAll() method invokes all of the Callable objects you pass to it in the collection passed as parameter.
     * The invokeAll() returns a list of Future objects via which you can obtain the results of the executions of each Callable.
     * Keep in mind that a task might finish due to an exception, so it may not have "succeeded".
     * There is no way on a Future to tell the difference
     *
     * output: execution 1
     * Inside task3
     * Inside task2
     * Inside task1
     * result=Task 1
     * result=Task 2
     * result=Task 3
     *
     */
    @DisplayName("ExecutorService invokeAny method")
    @Test
    void executorServiceInvokeAll(){
        Callable<String> task1 = () -> {
            log.info("Inside task1");
            return "Task 1";
        };

        Callable<String> task2 = () -> {
            log.info("Inside task2");
            return "Task 2";
        };

        Callable<String> task3 = () -> {
            log.info("Inside task3");
            return "Task 3";
        };

        Set<Callable<String>> callableSet = new HashSet<>();
        callableSet.add(task1);
        callableSet.add(task2);
        callableSet.add(task3);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Future<String>> resultList = executorService.invokeAll(callableSet);

            for(Future<String> future : resultList){
                log.info("result={}", future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception invokeAny", e);
        }
    }

    /**
     * When you are done using the Java ExecutorService you should shut it down, so the threads do not keep running.
     * If your application is started via a main() method and your main thread exits your application,
     * the application will keep running if you have an active ExexutorService in your application.
     * The active threads inside this ExecutorService prevents the JVM from shutting down
     *
     * To terminate the threads inside the ExecutorService you call its shutdown() method.
     * The ExecutorService will not shut down immediately, but it will no longer accept new tasks,
     * and once all threads have finished current tasks, the ExecutorService shuts down.
     * All tasks submitted to the ExecutorService before shutdown() is called, are executed.
     * Here is an example of performing a Java ExecutorService shutdown
     */
    @DisplayName("shutdown method")
    @Test
    void shutdownMethod(){
        Runnable thread1 = () -> log.info("Thread1, name={}", Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(thread1);
        executorService.shutdown();
    }

    /**
     * If you want to shut down the ExecutorService immediately, you can call the shutdownNow() method.
     * This will attempt to stop all executing tasks right away, and skips all submitted but non-processed tasks.
     * There are no guarantees given about the executing tasks. Perhaps they stop, perhaps the execute until the end.
     * It is a best effort attempt. Here is an example of calling ExecutorService shutdownNow:
     *
     */
    @DisplayName("shutdownNow method")
    @Test
    void shutdownNow(){
        Runnable thread1 = () -> log.info("Thread1, name={}", Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(thread1);
        executorService.shutdownNow();
    }

    /**
     * The ExecutorService awaitTermination() method will block the thread calling it until either
     * the ExecutorService has shutdown completely, or until a given time out occurs.
     * The awaitTermination() method is typically called after calling shutdown() or shutdownNow().
     * Here is an example of calling ExecutorService awaitTermination()
     */
    @DisplayName("shutdownNow method")
    @Test
    void awaitTermination(){
        Runnable thread1 = () -> log.info("Thread1, name={}", Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(thread1);
        executorService.shutdownNow();
        try {
            boolean await = executorService.awaitTermination(1000 * 5, TimeUnit.MILLISECONDS);
            log.info("await={}", await);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Callable and Future are used when we want to get result of thread execution.
     * Because Thread.run() method return type is void
     *
     * @see java.util.concurrent.Callable
     * @see java.util.concurrent.Future
     * <p>
     * output:
     * Inside callable2, thread-name=pool-1-thread-2
     * Inside callable1, thread-name=pool-1-thread-1
     * await=true
     * result=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * result=[11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
     */
    @DisplayName("Using Callable and Future to get result from thread execution")
    @Test
    void basicCallableFuture() {
        Callable<List<Integer>> callable1 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                log.info("Inside callable1, thread-name={}", Thread.currentThread().getName());
                return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            }
        };

        Callable<List<Integer>> callable2 = () -> {
            log.info("Inside callable2, thread-name={}", Thread.currentThread().getName());
            return Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        };

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<List<Integer>> resultFuture = executorService.submit(callable1);
        Future<List<Integer>> resultFuture2 = executorService.submit(callable2);
        executorService.shutdown();
        try {
            boolean await = executorService.awaitTermination(1, TimeUnit.HOURS);
            log.info("await={}", await);
        } catch (InterruptedException e) {
            log.error("Exception", e);
        }

        try {
            List<Integer> result = resultFuture.get();
            log.info("result={}", result);

            List<Integer> result2 = resultFuture2.get();
            log.info("result={}", result2);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception while getting result from Future", e);
        }
    }


}
