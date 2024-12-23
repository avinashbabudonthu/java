package com.practice.java.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ArrayListTest {

    @Test
    void createList() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        log.info("list1={}", list1);
    }

    @Test
    void stringToList() {
        String inputString1 = "a,b,c,d,e";
        List<Object> list1 = stringToList(inputString1, ",");
        log.info("list1={}", list1); // list1=[a, b, c, d, e]

        String inputString2 = "f;g;h;i;j;k";
        List<Object> list2 = stringToList(inputString2, ";");
        log.info("list2={}", list2); // list2=[f, g, h, i, j, k]
    }

    private List<Object> stringToList(String inputString, String delimiter) {
        String[] strings = inputString.split(delimiter);
        return new ArrayList<>(Arrays.asList(strings));
    }

    @Test
    void listToString() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        String result1 = listToString(list1, ",");
        log.info("result1={}", result1); // result1=a,b,c,d,e

        String result2 = listToString(list1, ";");
        log.info("result2={}", result2); // result2=a;b;c;d;e
    }

    private String listToString(List<?> list, String delimiter) {
        List<String> stringList = list.stream().map(Object::toString).toList();
        return String.join(delimiter, stringList);
    }

    @Test
    void listToArray() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        String[] stringArray = list1.toArray(String[]::new);
        log.info("stringArray = {}", Arrays.deepToString(stringArray)); // stringArray = [a, b, c, d, e]

        Object[] objectArray = list1.toArray(Object[]::new);
        log.info("objectArray = {}", Arrays.deepToString(objectArray)); // objectArray = [a, b, c, d, e]
    }

    @Test
    void listToStringWithPrefixAndSuffix() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        String result1 = list1.stream().collect(Collectors.joining("','", "'", "'"));
        log.info("result1 = {}", result1); // result1 = 'a','b','c','d','e'
    }

    @Test
    void setToList() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        set1.add("e");
        log.info("set1={}", set1); // set1=[a, b, c, d, e]

        List<String> list1 = new ArrayList<>(set1);
        log.info("list1={}", list1); // list1=[a, b, c, d, e]
    }

    @Test
    public void createArrayList() {
        List<String> list = new ArrayList<>();
        log.info("list={}", list);
    }

    @Test
    public void add() {
        log.info("---- method 1 ---");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        log.info("list1={}", list1);

        log.info("---  method 2 ---");
        List<String> list2 = Arrays.asList("4", "5", "6");
        log.info("list={}", list2);
    }

    @Test
    public void addAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        log.info("before list1={}", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        log.info("before list2={}", list2);

        list1.addAll(list2);
        log.info("after list1={}", list1);
    }

    @Test
    public void remove() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        log.info("original - list1={}", list1);

        list1.remove("1");
        log.info("remove element 1 - list1={}", list1);

        list1.remove(2);
        log.info("remove element by index - list1={}", list1);
    }

    /**
     * If we do not type cast - remove(index) will be called
     * If we type cast - remove(Object) will be called
     */
    @Test
    public void removeIntegerByValueFromIntegerList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        log.info("numbers={}", numbers);
        numbers.remove((Integer) 5);
        log.info("numbers={}", numbers);

        Integer number = 4;
        numbers.remove(number);
        log.info("numbers={}", numbers);

        numbers.remove((Object) 3);
        log.info("numbers={}", numbers);
    }

    @Test
    public void removeAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        log.info("list1 before={}", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("c");
        log.info("list2={}", list2);

        list1.removeAll(list2);
        log.info("list1 after={}", list1);
    }

    @Test
    public void subList() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        log.info("before list1={}", list1);

        List<String> subList = list1.subList(1, 3);
        log.info("sublist(1, 3)={}", subList);

        // adding element to subList will reflect in actual list
        log.info("-- add element 6 to sublist --");
        subList.add("6");
        log.info("subList={}", subList);
        log.info("list1={}", list1);

        // deleting element from subList will reflect in actual list
        log.info("-- remove element 3 from sublist --");
        subList.remove("3");
        log.info("subList={}", subList);
        log.info("list1={}", list1);
    }

    @Test
    public void iterate() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");

        // using iterator
        log.info("-- iterate using iterator --");
        Iterator<String> list1Iterator = list1.iterator();
        while (list1Iterator.hasNext()) {
            log.info("iterator.element={}", list1Iterator.next());
        }

        // using for loop
        log.info("-- iterate using for loop --");
        for (int i = 0; i < list1.size(); i++) {
            log.info("list1[{}]={}", i, list1.get(i));
        }

        // for each
        log.info("-- iterate using for each loop --");
        for (String element : list1) {
            log.info("element={}", element);
        }

        // stream
        log.info("-- iterate using stream --");
        list1.stream().forEach(element -> log.info("element={}", element));
    }

    @Test
    public void toArray() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        // to object array
        log.info("-- to Object array : Object[] --");
        Object[] objectArray = list1.toArray();
        Stream.of(objectArray).forEach(element -> log.info("element={}", element));

        // to String array
        log.info("-- to String array, passing array size: String[] --");
        String[] stringArray = list1.toArray(new String[list1.size()]);
        Stream.of(stringArray).forEach(element -> log.info("element={}", element));

        log.info("-- to String array without passing array size : String[] ");
        String[] stringArray2 = list1.toArray(new String[] {});
        Stream.of(stringArray2).forEach(element -> log.info("element={}", element));
    }

    @Test
    public void sortUsingComparable() {
        Student student1 = Student.builder().name("jim").grade(3.12).build();
        Student student2 = Student.builder().name("jack").grade(3.25).build();
        Student student3 = Student.builder().name("john").grade(3.10).build();
        Student student4 = Student.builder().name("jane").grade(3.35).build();
        Student student5 = Student.builder().name("jill").grade(3.05).build();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        log.info("-- before sort --");
        log.info("students={}", students);

        Collections.sort(students);
        log.info("-- after sort --");
        log.info("students={}", students);
    }

    @Test
    public void sortUsingComparator() {
        Student student1 = Student.builder().name("jim").grade(3.12).build();
        Student student2 = Student.builder().name("jack").grade(3.25).build();
        Student student3 = Student.builder().name("john").grade(3.10).build();
        Student student4 = Student.builder().name("jane").grade(3.35).build();
        Student student5 = Student.builder().name("jill").grade(3.05).build();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        log.info("-- before sort --");
        log.info("students={}", students);

        Comparator<Student> nameComparator = (s1, s2) -> s1.getName().compareTo(s2.getName());
        log.info("-- sort by name --");
        students.sort(nameComparator);
        log.info("students={}", students);

        Comparator<Student> gradeComparator = (s1, s2) -> s2.getGrade().compareTo(s1.getGrade());
        log.info("-- sort by grade desc --");
        students.sort(gradeComparator);
        log.info("students={}", students);
    }

    /**
     * 1. list of student objects
     * 2. remove duplicates in list by student name
     */
    @Test
    public void removeDuplicatesInListByStudentName() {
        Student jack1 = Student.builder().name("jack").grade(3.12).build();
        Student tim1 = Student.builder().name("tim").grade(3.15).build();
        Student jim = Student.builder().name("jim").grade(3.13).build();
        Student jill = Student.builder().name("jill").grade(3.14).build();
        Student jack2 = Student.builder().name("jack").grade(3.16).build();
        Student tim2 = Student.builder().name("tim").grade(3.17).build();

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(jack1);
        studentsList.add(tim1);
        studentsList.add(jim);
        studentsList.add(jill);
        studentsList.add(jack2);
        studentsList.add(tim2);

        log.info("actual list - size={}", studentsList.size());
        studentsList.stream().forEach(student -> log.info("{}", student));

        List<Student> uniqueStudentsList = new ArrayList<>();
        Set<String> studentNamesSet = new HashSet<>();

        for (Student student : studentsList) {
            if (studentNamesSet.add(student.getName())) {
                uniqueStudentsList.add(student);
            }
        }

        log.info("unique names, size={}", studentNamesSet.size());
        studentNamesSet.stream().forEach(name -> log.info("{}", name));

        log.info("unique students list, size={}", uniqueStudentsList.size());
        uniqueStudentsList.stream().forEach(student -> log.info("{}", student));

        // using java 8 streams
        List<String> list = new ArrayList<>();
        list.add("jack");
        list.add("jack");
        list.add("jill");
        list.add("jill");
        list.add("john");
        list.add("john");
        log.info("list={}", list);
        List<String> listWithoutDuplicates = list.stream().distinct().collect(Collectors.toList());
        log.info("listWithoutDuplicates={}", listWithoutDuplicates);
    }

    /**
     * Remove null objects from list
     */
    @Test
    public void removeNullsFromList() {
        List<String> names = new ArrayList<>();
        names.add("jack");
        names.add(null);
        names.add("jill");
        names.add(null);
        names.add("jim");
        names.add(null);
        names.add("tim");

        log.info("names={}", names);

        Set<?> nullSet = Collections.singleton(null);

        names.removeAll(nullSet);

        log.info("names={}", names);
    }

    @Test
    public void min() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Optional<Integer> minNumber = list.stream().min(Integer::compareTo);
        log.info("minNumber={}", minNumber);
    }

    @Test
    public void forEach() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.stream().forEach(value -> log.info("value={}", value));
    }

    /**
     * 1. Order is not maintained on using parallelStream
     */
    @Test
    public void forEachUsingParallelStream() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.parallelStream().forEach(value -> log.info("value={}", value));
    }

    @Test
    public void filter() {
    }

    @Test
    public void filterAndMin() {

    }

    @Test
    public void filterAndMax() {

    }

    @Test
    public void filterAndSum() {

    }

    @Test
    public void filterAndCount() {

    }

    @Test
    public void averageOfInt() {

    }

    @Test
    public void averageOfDouble() {

    }

    @Test
    public void max() {

    }

    @Test
    public void sum() {

    }

    @Test
    public void count() {

    }

    @Test
    public void reduce() {

    }

    @Test
    public void collect() {

    }

    @Test
    public void groupByUsingParallelStream() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().name("jim").gender("M").build());
        employeeList.add(Employee.builder().name("jane").gender("F").build());
        employeeList.add(Employee.builder().name("john").gender("M").build());
        employeeList.add(Employee.builder().name("Ani").gender("F").build());

        ConcurrentMap<String, List<Employee>> groupByGender = employeeList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getGender));
        log.info("groupByGender={}", groupByGender);
    }

    @Test
    public void convertListToMap() {
        List<Employee> employeesList = new ArrayList<>();
        employeesList
                .add(Employee.builder().id(1).name("jack").gender("M").salary(1001L).department("accounts").build());
        employeesList.add(Employee.builder().id(2).name("jill").gender("F").salary(1002L).department("hr").build());
        employeesList
                .add(Employee.builder().id(3).name("jim").gender("M").salary(1003L).department("transport").build());
        employeesList
                .add(Employee.builder().id(4).name("josh").gender("M").salary(1004L).department("accounts").build());
        employeesList
                .add(Employee.builder().id(5).name("jane").gender("F").salary(1005L).department("transport").build());
        employeesList.add(Employee.builder().id(6).name("Ana").gender("F").salary(1006L).department("hr").build());
        employeesList
                .add(Employee.builder().id(7).name("john").gender("F").salary(1007L).department("accounts").build());

        // key == id, value == name
        Map<Integer, String> idToNameMap = employeesList.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        log.info("id-to-name-map={}", idToNameMap);

        // key == name, value == salary
        Map<String, Long> nameToSalaryMap = employeesList.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        log.info("name-to-salary-map={}", nameToSalaryMap);

        // key == department, value == name. Without 3rd argument we will get exception
		/*
		 * java.lang.IllegalStateException: Duplicate key jack
			at java.util.stream.Collectors.lambda$throwingMerger$0(Collectors.java:133)
			at java.util.HashMap.merge(HashMap.java:1253)
		 */
        Map<String, String> departmentToNameMap = employeesList.stream().collect(Collectors
                .toMap(Employee::getDepartment, Employee::getName, (oldValue, newValue) -> oldValue + ", " + newValue));
        log.info("department-to-name-map={}", departmentToNameMap);

        // key == name, value == employee object itself - using lambda
        Map<String, Employee> nameToEmployeeMap = employeesList.stream()
                .collect(Collectors.toMap(Employee::getName, emp -> emp));
        log.info("name-to-employee-map={}", nameToEmployeeMap);

        // key == name, value == employee object itself - using Function.identity()
        Map<String, Employee> nameToEmployeeMap2 = employeesList.stream()
                .collect(Collectors.toMap(Employee::getName, Function.identity()));
        log.info("name-to-employee-map={}", nameToEmployeeMap2);
    }

    @Test
    public void splitList() {
        List<Integer> srcList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(splitList(srcList, 2));
        System.out.println(splitList(srcList, 3));
        System.out.println(splitList(srcList, 4));
        System.out.println(splitList(srcList, 5));
        System.out.println(splitList(srcList, 10));
        System.out.println(splitList(srcList, 15));
    }

    private <T> List<List<T>> splitList(List<T> srcList, final int lengthOfSubList) {
        List<List<T>> splits = new ArrayList<>();
        final int size = srcList.size();
        for (int i = 0; i < size; i = i + lengthOfSubList) {
            splits.add(new ArrayList<T>(srcList.subList(i, Math.min(size, i + lengthOfSubList))));
        }
        return splits;
    }

    @Test
    public void convertArrayToList() {
        String[] stringArray = new String[] { "A", "B", "C", "D" };

        // method 1
        List<String> stringList = Arrays.asList(stringArray);
        System.out.println("stringList: " + stringList);

        // method 2
        List<String> stringList2 = new ArrayList<>(Arrays.asList(stringArray));
        System.out.println("stringList2: " + stringList2);

        // method 3
        int[] numbersArray1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> numbersList1 = new ArrayList<>();
        for (int number : numbersArray1) {
            numbersList1.add(number);
        }
        System.out.println("numbersList1: " + numbersList1);

        // method 4
        Integer[] numbersArray3 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> numbersList3 = Arrays.asList(numbersArray3);
        System.out.println("numbersList3: " + numbersList3);

        // from java 8
        int[] numbersArray2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> numbersList2 = Arrays.stream(numbersArray2).boxed().collect(Collectors.toList());
        System.out.println("numbersList2: " + numbersList2);
    }

    @Test
    public void convertListToArray() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        System.out.println("list1: " + list1);

        String[] list1Array = list1.toArray(new String[list1.size()]);
        for (String value : list1Array) {
            System.out.print(value + ",");
        }
    }

    @Test
    public void convertListToCommaSeparatedString() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        //method 1
        StringBuffer listToString1 = new StringBuffer(list.toString());
        listToString1.deleteCharAt(0);
        listToString1.deleteCharAt(listToString1.length() - 1);
        String destString = listToString1.toString().replace(" ", "");
        System.out.println("listToString1: " + destString);

        // method 2
        Iterator<String> iterator = list.iterator();
        StringBuffer listToString2 = new StringBuffer();
        for (;;) {
            listToString2.append(iterator.next());
            if (!iterator.hasNext())
                break;
            listToString2.append(",");
        }
        System.out.println("listToString2: " + listToString2);

        // method 3
        StringBuffer listToString3 = new StringBuffer("[");
        for (Iterator<String> iterator2 = list.iterator(); iterator2.hasNext();) {
            listToString3.append(iterator2.next());
            if (iterator2.hasNext()) {
                listToString3.append(",");
            }
        }
        listToString3.append("]");
        System.out.println("listToString3: " + listToString3.toString());

        // method 4
        String listToString4 = String.join("-", list);
        System.out.println("listToString4: " + listToString4);

        // method 5
        Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        List<String> stringList = Arrays.stream(intArray).map(String::valueOf).collect(Collectors.toList());
        String listToString5 = String.join("-", stringList);
        System.out.println("listToString5: " + listToString5);

        // method 6
        List<String> list2 = Arrays.asList("jack", "john", "jim", "jane");
        String str = list2.stream().map(x -> x).collect(Collectors.joining(","));
        System.out.println("str:" + str);
    }

    /**
     * list1 = {a,b,c,d,e}
     * list2 = {a,b,c,f,g,h}
     * output = {a,b,c,d,e,f,g,h}
     */
    @Test
    public void prepareNewListWithUniqueValues() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");

        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("f");
        list2.add("g");
        list2.add("h");

        List<String> commonElementsList = new ArrayList<>(list2);
        commonElementsList.retainAll(list1);
        list2.removeAll(commonElementsList);
        list1.addAll(list2);
        System.out.println(list1);
    }

    /**
     * Create immutable list
     */
    @Test
    public void immutableList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("list: " + list);
        List<String> immutableList = Collections.unmodifiableList(list);
        System.out.println("immutableList: " + immutableList);

        try {
            immutableList.add("d");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> list1 = List.of("b");
        log.info("list1={}", list1); // list1=[b]

        List<String> list2 = List.of("b", "c", "d");
        List<String> list3 = Collections.unmodifiableList(list2);
        log.info("list3 = {}", list3); // list3 = [b, c, d]
    }

    /**
     * Sort list of student by grade. If grade is equal sort by name
     */
    @Test
    public void sortByGradeAndName() {
        Student student1 = Student.builder().name("john").grade(3.12).build();
        Student student2 = Student.builder().name("jane").grade(3.25).build();
        Student student3 = Student.builder().name("jim").grade(3.12).build();
        Student student4 = Student.builder().name("jack").grade(3.25).build();
        Student student5 = Student.builder().name("jill").grade(3.45).build();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        log.info("before sort, students={}", students);

        Comparator<Student> gradeAndNameComparator = (s1, s2) -> {
            int result = s1.getGrade().compareTo(s2.getGrade());
            if (0 == result) {
                result = s1.getName().compareTo(s2.getName());
            }
            return result;
        };

        students.sort(gradeAndNameComparator);
        log.info("sort by grade and name , students={}", students);
    }

    @Test
    public void listToSortedMapByKey() {
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(Employee.builder().id(2).name("jill").gender("F").salary(1002L).department("hr").build());
        employeesList
                .add(Employee.builder().id(4).name("josh").gender("M").salary(1004L).department("accounts").build());
        employeesList
                .add(Employee.builder().id(7).name("john").gender("F").salary(1007L).department("accounts").build());
        employeesList
                .add(Employee.builder().id(3).name("jim").gender("M").salary(1003L).department("transport").build());

        employeesList
                .add(Employee.builder().id(5).name("jane").gender("F").salary(1005L).department("transport").build());
        employeesList.add(Employee.builder().id(6).name("Ana").gender("F").salary(1006L).department("hr").build());
        employeesList
                .add(Employee.builder().id(1).name("jack").gender("M").salary(1001L).department("accounts").build());

        // @formatter:off
        Map<String, Long> ascendingOrderOfNames = employeesList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toMap(
                                Employee::getName,  // key == name
                                Employee::getSalary,  // value == salary
                                (oldValue, newValue) -> newValue, // keep new value
                                LinkedHashMap::new // return LinkedHashMap, for insertion order
                        )
                );
        // @formatter:on
        log.info("asending order by name map={}", ascendingOrderOfNames);
    }

    @Test
    public void listToSortedMapByValue() {
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(Employee.builder().id(2).name("jill").gender("F").salary(1002L).department("hr").build());
        employeesList
                .add(Employee.builder().id(4).name("josh").gender("M").salary(1004L).department("accounts").build());
        employeesList
                .add(Employee.builder().id(7).name("john").gender("F").salary(1007L).department("accounts").build());
        employeesList
                .add(Employee.builder().id(3).name("jim").gender("M").salary(1003L).department("transport").build());

        employeesList
                .add(Employee.builder().id(5).name("jane").gender("F").salary(1005L).department("transport").build());
        employeesList.add(Employee.builder().id(6).name("Ana").gender("F").salary(1006L).department("hr").build());
        employeesList
                .add(Employee.builder().id(1).name("jack").gender("M").salary(1001L).department("accounts").build());

        // @formatter:off
        Map<String, Long> descendingOrderOfSalary = employeesList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .collect(Collectors.toMap(
                                Employee::getName,  // key == name
                                Employee::getSalary,  // value == salary
                                (oldValue, newValue) -> newValue, // keep new value
                                LinkedHashMap::new // return LinkedHashMap, for insertion order
                        )
                );
        // @formatter:on
        log.info("descending order of salary={}", descendingOrderOfSalary);

    }

    @Test
    public void reverseList() {
        // solution 1
        List<String> names = new ArrayList<>();
        names.add("jack");
        names.add("jill");
        names.add("jim");
        names.add("jane");
        log.info("before\n names={}", names);
        Collections.reverse(names);
        log.info("after\n names={}", names);

    }

    @Test
    public void intersection() {
        List<String> list1 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> list2 = Arrays.asList("f", "g", "h", "a", "b");

        Set<String> result = list1.stream().distinct().filter(list2::contains).collect(Collectors.toSet());
        log.info("list1={}", list1);
        log.info("list2={}", list2);
        log.info("result={}", result);

        // intersection of list of custom objects
        Student student1 = Student.builder().name("Ava").grade(3.1D).build();
        Student student2 = Student.builder().name("Amelia").grade(3.2D).build();
        Student student3 = Student.builder().name("Avery").grade(3.3D).build();
        Student student4 = Student.builder().name("Aiden").grade(3.4D).build();
        Student student5 = Student.builder().name("Abigail").grade(3.5D).build();
        Student student6 = Student.builder().name("Aria").grade(3.6D).build();
        Student student7 = Student.builder().name("Aaron").grade(3.7D).build();
        Student student8 = Student.builder().name("Angel").grade(3.8D).build();
        List<Student> studentList1 = Arrays.asList(student1, student2, student3, student4, student5);
        List<Student> studentList2 = Arrays.asList(student1, student2, student6, student7, student8);

        Set<Student> commonStudents = studentList1.stream().distinct().filter(studentList2::contains)
                .collect(Collectors.toSet());
        log.info("studentList1={}", studentList1);
        log.info("studentList2={}", studentList2);
        log.info("commonStudents={}", commonStudents);
    }

    /**
     * Sort the list in reverse order
     */
    @Test
    public void sortListInReverseOrder() {
        List<String> names2 = new ArrayList<>();
        names2.add("jack");
        names2.add("jill");
        names2.add("jim");
        names2.add("jane");
        log.info("before\n names2={}", names2);
        names2.sort(Collections.reverseOrder());
        log.info("after\n names2={}", names2);
    }

    /**
     * Output:
     sizeOfEachSubList=1
     [[a]]
     sizeOfEachSubList=1
     [[a], [b]]
     sizeOfEachSubList=1
     [[a], [b], [c]]
     sizeOfEachSubList=1
     [[a], [b], [c], [d]]
     sizeOfEachSubList=2
     [[a, b], [c, d], [e]]
     */
    @Test
    public void splitListToSubLists() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        splitListToSubLists(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        splitListToSubLists(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        splitListToSubLists(list3);

        List<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("b");
        list4.add("c");
        list4.add("d");
        splitListToSubLists(list4);

        List<String> list5 = new ArrayList<>();
        list5.add("a");
        list5.add("b");
        list5.add("c");
        list5.add("d");
        list5.add("e");
        splitListToSubLists(list5);
    }

    private void splitListToSubLists(List<String> list) {
        int sizeOfEachSubList = (int) Math.ceil((float) list.size() / 4);
        log.info("sizeOfEachSubList={}", sizeOfEachSubList);
        List<List<String>> groupedList = Lists.partition(list, sizeOfEachSubList);
        log.info("{}", groupedList);
    }

    @Test
    public void removeIf() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        log.info("list={}", list);

        // list.removeIf(value -> "c".equalsIgnoreCase(value));
        list.removeIf("c"::equalsIgnoreCase);
        log.info("list={}", list);
    }

    @Test
    public void flatMap(){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        list.add(map);
        String[] result = list.stream().map(Map::keySet).flatMap(Collection::stream).distinct().sorted().toArray(String[]::new);
        for(String row : result){
            System.out.println(row);
        }
    }

}