# Generics Notes

## Notes
* Upper Bounded wild card
```
List<? extends Class>
```
* Upper bounded wild card example
```
private void method4(List<? extends  Number> list){
}

public void method5(){
    List<Integer> list1 = new ArrayList<>();
    method4(list1);

    List<Double> list2 = new ArrayList<>();
    method4(list2);
}
```
* Lower Bounded wild card
```
List<? super Class>
```
* Lower bounded wild card example
```
private void method6(List<? super Integer> list){
}

public void method7(){
    List<Object> list1 = new ArrayList<>();
    method6(list1);

    List<Integer> list2 = new ArrayList<>();
    method6(list2);

    List<Number> list3 = new ArrayList<>();
    method6(list3);
}
```
* Unbounded wild card
```
List<?>
```
* Unbounded wild card example
```
public static void printList(List<?> list) {
    for (Object elem: list)
        System.out.print(elem + " ");
    System.out.println();
}

List<Integer> li = Arrays.asList(1, 2, 3);
List<String>  ls = Arrays.asList("one", "two", "three");
printList(li);
printList(ls);
```
------
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
