# Generics Notes

## Notes
* Upper Bounded wild card
```
List<? extends Class>
```
* Lower Bounded wild card
```
List<? super Class>
```
* List<?>
```
Unbounded wild card
```

## Erasure
* After compilation generics will be removed
```
List<string>, List<Integer> , List<List<Integer>> -> List
List<String>[] - List[]
T without bounds -> Object
T extends Foo -> Foo
```
* Compilation Error, after compilation both List&lt;String&gt; and List&lt;Integer&gt; will be converted to List as explained in Erasure
```
public void print(List<String> list) { --} 
public void print(List<Integer> list) { --} 
This will throw compile error - both methods have same erasure
```