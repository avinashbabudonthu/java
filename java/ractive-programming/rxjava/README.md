# Notes
------
## What is the meaning of Ractive programming?
* Making applications event driven, so that they structured in a way that they works well with concurrency
* Good structure for decoupling modules from each other
* Making application `Scalable`
* Making application `Resilient` in load and failure conditions
* Making application `Responsive`

## What is RXJava
* Java based extension to ReactiveX
* Key characteristics of RXJava
	* extends observer pattern
	* supports sequences of data/events
	* provides operators to compose sequences together declaratively
	* handles threading, synchronization, thread-safety, concurrent data structures internally

## Functional Programming Pure Functions
* method1 in below code is pure function because
	* it is thread safe
	* no dependency on state of the object
```
public class AppClass{
	public void method1(int i){
		return i+10;
	}
}
```
* method2 in below code is impure function because
	* it has dependency on instance variable `j`
	* if multiple threads executing method2 then results are unpredicable
```
public class AppClass{
	private int j = 10;
	
	public void method2(int i){
		j = j + 20;
		return i+j;
	}
}
```

## Reactive programming concepts
* [Documentation](https://www.reactivemanifesto.org/)
* Event Driven
* Scalable
* Resilient
* Responsive

## Observer pattern
* We have `Observable` object
* we will have one or more `observer` objects that subscribe themselves to observable
* Now any changes to observable are sent to observers as notifications. These notifications can be synchronous or concurrent

### RXJava use of Observer pattern
* RXJava also have `Observable<T>`, `Observer<T>`
* Notice that they are generic
* notifications from observable to observers are sent concurrently. RXJava handles threading for concurrency

### Reactive programming Resilience
* Graceful error handling
* Manager failure

## Observer interface
* Implements `Observer` interface and call `subscribe` on desirable `Observable`
* 3 methods in `Observer` interface
	* onNext(T): Is called on observer each time new event is published to observable. In this we will write code to perform some action on each event
	* onCompleted(T): When sequence of events with associate observable is complete. Means we will not expect any more onNext calls on observer
	* onError(T): called with unhandled exception is thrown during RXJava framework code or in event handling code. Once onError is called no further onNext, onCompleted calls will happen

## Subscription interface
* Return value for observer `subscribe` method
* 1 method in `Subscription` interface
	* unsubscribe(): called to disconnect observer from observable to which it is subscribed

## Observables in RXJava
* 2 types of observables in RXJava
	* Non blocking observables
		* Super class is - `Observable`
		* asynchronous execution is supported
		* Can unsubscribe at any point in the event stream
		* RXJava is single threaded by default. So if we want asynchronous execution, we need to do configure observables
	* Blocking Observable
		* Super class - `BlockingObservable`
		* BlockingObservable` extends Observable
		* Events are synchronous
		* Cannot unsubscribe in the middle of event stream
* Methods
	* subscribeOn(Scheduler): pass scheduler that determines the thread that code runs on when we call subscribe method. If scheduler is not specified then currentThread is used call subscribe
	* observeOn(Scheduler): determines the scheduler used during onNext,onCompleted, onError calls inside observer
* creating Observable - `Observable.from(..)`
		
## Schedulers
* RXJava allows what thread has to execute the code through schedulers
* class - `Schedulers`
	* computation(): this is scheduler that will have number of threads available equal to the number processing cores within the computer. Used for computation work
	* currentThread(): once current work is finished, run event code to run within current thread
	* immediate(): opposite to `currentThread`. Immediately invokes handled code within the current thread
	* io(): scheduler used by long running I/O processes like network communication or db operations. Backed by thread pool to support I/O operations
	* newThread(): scheduler to create new thread for each unit of work
	* executor(Executor): used to wrap java Executor interface with proper schedule interface that is RXJava compatible
	* executor(ScheduledExecutor): Supports Java ScheduledExecutor
	