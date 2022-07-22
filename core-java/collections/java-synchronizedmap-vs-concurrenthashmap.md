# Collections.synchronizedMap vs. ConcurrentHashMap
* 
## Overview
* In this tutorial, we'll discuss the differences between Collections.synchronizedMap() and ConcurrentHashMap.
* Additionally, we'll look at the performance outputs of the read and write operations for each.

## The Differences
* Collections.synchronizedMap() and ConcurrentHashMap both provide thread-safe operations on collections of data.
* The Collections utility class provides polymorphic algorithms that operate on collections and return wrapped collections. Its synchronizedMap() method provides thread-safe functionality.
* As the name implies, synchronizedMap() returns a synchronized Map backed by the Map that we provide in the parameter. To provide thread-safety, synchronizedMap() allows all accesses to the backing Map via the returned Map.
* ConcurrentHashMap was introduced in JDK 1.5 as an enhancement of HashMap that supports high concurrency for retrievals as well as updates. HashMap isn't thread-safe, so it might lead to incorrect results during thread contention.
* The ConcurrentHashMap class is thread-safe. Therefore, multiple threads can operate on a single object with no complications.
* In ConcurrentHashMap, read operations are non-blocking, whereas write operations take a lock on a particular segment or bucket. The default bucket or concurrency level is 16, which means 16 threads can write at any instant after taking a lock on a segment or bucket.

## ConcurrentModificationException
* For objects like HashMap, performing concurrent operations is not allowed. Therefore, if we try to update a HashMap while iterating over it, we will receive a ConcurrentModificationException. This will also occur when using synchronizedMap():
```
@Test(expected = ConcurrentModificationException.class)
public void whenRemoveAndAddOnHashMap_thenConcurrentModificationError() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "baeldung");
    map.put(2, "HashMap");
    Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
    Iterator<Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
    while (iterator.hasNext()) {
        synchronizedMap.put(3, "Modification");
        iterator.next();
    }
}
```
* However, this is not the case with ConcurrentHashMap:
```
Map<Integer, String> map = new ConcurrentHashMap<>();
map.put(1, "baeldung");
map.put(2, "HashMap");
 
Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
while (iterator.hasNext()) {
    map.put(3, "Modification");
    iterator.next()
}
 
Assert.assertEquals(3, map.size());
```
## null Support
* Collections.synchronizedMap() and ConcurrentHashMap handle null keys and values differently.
* ConcurrentHashMap doesn't allow null in keys or values:
```
@Test(expected = NullPointerException.class)
public void allowNullKey_In_ConcurrentHasMap() {
    Map<String, Integer> map = new ConcurrentHashMap<>();
    map.put(null, 1);
}
```
* However, when using Collections.synchronizedMap(), null support depends on the input Map. We can have one null as a key and any number of null values when Collections.synchronizedMap() is backed by HashMap or LinkedHashMap, whereas if we're using TreeMap, we can have null values but not null keys.
* Let's assert that we can use a null key for Collections.synchronizedMap() backed by a HashMap:
```
Map<String, Integer> map = Collections
  .synchronizedMap(new HashMap<String, Integer>());
map.put(null, 1);
Assert.assertTrue(map.get(null).equals(1));
```
* Similarly, we can validate null support in values for both Collections.synchronizedMap() and ConcurrentHashMap.

## Performance Comparison
* Let's compare the performances of ConcurrentHashMap versus Collections.synchronizedMap(). In this case, we're using the open-source framework Java Microbenchmark Harness (JMH) to compare the performances of the methods in nanoseconds.
* We ran the comparison for random read and write operations on these maps. Let's take a quick look at our JMH benchmark code:
```
@Benchmark
public void randomReadAndWriteSynchronizedMap() {
    Map<String, Integer> map = Collections.synchronizedMap(new HashMap<String, Integer>());
    performReadAndWriteTest(map);
}

@Benchmark
public void randomReadAndWriteConcurrentHashMap() {
    Map<String, Integer> map = new ConcurrentHashMap<>();
    performReadAndWriteTest(map);
}

private void performReadAndWriteTest(final Map<String, Integer> map) {
    for (int i = 0; i < TEST_NO_ITEMS; i++) {
        Integer randNumber = (int) Math.ceil(Math.random() * TEST_NO_ITEMS);
        map.get(String.valueOf(randNumber));
        map.put(String.valueOf(randNumber), randNumber);
    }
}
```
* We ran our performance benchmarks using 5 iterations with 10 threads for 1,000 items. Let's see the benchmark results:
  * results show that ConcurrentHashMap performs better than Collections.synchronizedMap()
## When to Use
* We should favor Collections.synchronizedMap() when data consistency is of utmost importance, and we should choose ConcurrentHashMap for performance-critical applications where there are far more write operations than there are read operations.
* This is because the Collections.synchronizedMap() requires each thread to acquire a lock on the entire object for both read/write operations. By comparison, the ConcurrentHashMap allows threads to acquire locks on separate segments of the collection, and make modifications at the same time.
