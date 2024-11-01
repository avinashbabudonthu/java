package com.practice.enums;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class EnumIssue {
    public static final Map<String, Employee> map = Maps.uniqueIndex(List.of(Employee.values()), Employee::getName);

    public int i = 10;
    public String name = "c";

    public enum Employee {
        A("a", "d1", "address1"),
        B("b", "d1", "address2");

        Employee(String name, String dept, String address) {
            this.name = name;
            this.dept = dept;
            this.address = address;
        }

        private String name;
        private String dept;
        private String address;

        public String getName() {
            return name;
        }

        public String getDept() {
            return dept;
        }

        public String getAddress() {
            return address;
        }

        // working
        /*static {
            Employee[] employees = Employee.values();
        }*/

//        working
//        static Employee[] employees = Employee.values();

        // throws error
//        Employee[] employees = Employee.values();
//        static String names = Arrays.stream(Employee.values()).map(Employee::getName).collect(Collectors.joining(","));

    }

    public EnumIssue() {
        System.out.println("Inside EnumIssue()");
    }

    public static void main(String[] args) {
        new EnumIssue().run();
    }

    private void run() {
        System.out.println(map);
//        System.out.println(Employee.A.names);
    }
}
