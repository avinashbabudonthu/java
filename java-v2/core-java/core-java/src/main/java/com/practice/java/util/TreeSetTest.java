package com.practice.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class TreeSetTest {

    @Test
    public void add(){
        Set<String> set = new TreeSet<>();
        set.add("4");
        set.add("2");
        set.add("1");
        set.add("3");
        log.info("set={}", set);
    }

    @Test
    public void customClassInTreeSet(){
        Employee employee1 = Employee.builder().name("jack").designation("se").build();
        Employee employee2 = Employee.builder().name("jim").designation("se2").build();
        Employee employee3 = Employee.builder().name("jane").designation("se3").build();

        final Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getName);
        Set<Employee> employeesSet = new TreeSet<>(
                employeeComparator
        );
        employeesSet.add(employee1);
        employeesSet.add(employee2);
        employeesSet.add(employee3);
        log.info("employeesSet={}", employeesSet);
    }

    @Test
    public void iterate(){
        Comparator<Employee> byNameComparator = Comparator.comparing(Employee::getName);
        Set<Employee> employeeSet = new TreeSet<>(byNameComparator);
        employeeSet.add(Employee.builder().name("jim").designation("se2").build());
        employeeSet.add(Employee.builder().name("jack").designation("se1").build());

        // using iterator
        Iterator<Employee> iterator = employeeSet.iterator();
        while (iterator.hasNext()){
            log.info("employee={}", iterator.next());
        }
    }

    @Test
    public void first(){
        Set<String> set = new TreeSet<>();
        set.add("3");
        set.add("1");
        set.add("5");
        set.add("4");
        set.add("7");
        set.add("6");
        log.info("set={}", set);

        String firstElement = ((TreeSet<String>)set).first();
        log.info("firstElement={}", firstElement);
    }

    @Test
    public void last(){
        Set<String> set = new TreeSet<>();
        set.add("3");
        set.add("1");
        set.add("5");
        set.add("4");
        set.add("7");
        set.add("6");
        log.info("set={}", set);

        String last = ((TreeSet<String>) set).last();
        log.info("last={}", last);
    }

    @Test
    public void tailSet(){
        Set<String> set = new TreeSet<>();
        set.add("3");
        set.add("1");
        set.add("5");
        set.add("4");
        set.add("7");
        set.add("6");
        log.info("set={}", set);

        Set<String> tailSet1 = ((TreeSet<String>) set).tailSet("4");
        log.info("tailSet1={}", tailSet1);

        Set<String> tailSet2 = ((TreeSet<String>) set).tailSet("4", true);
        log.info("tailSet=2{}", tailSet2);
    }

    @Test
    public void headSet(){
        Set<String> set = new TreeSet<>();
        set.add("3");
        set.add("1");
        set.add("5");
        set.add("4");
        set.add("7");
        set.add("6");
        log.info("set={}", set);

        Set<String> headSet1 = ((TreeSet<String>)set).headSet("4");

    }

    @Test
    public void subSet(){
        Set<String> set = new TreeSet<>();
        set.add("3");
        set.add("1");
        set.add("5");
        set.add("4");
        set.add("7");
        set.add("6");
        log.info("set={}", set);

        Set<String> subSet = ((TreeSet<String>) set).subSet("3", "6");
        log.info("subSet={}", subSet);
    }

    @Test
    public void lower(){

    }

    @Test
    public void higher(){

    }

    @Test
    public void floor(){

    }

    @Test
    public void ceiling(){

    }

    @Test
    public void pollFirst(){

    }

    @Test
    public void pollLast(){

    }
}
