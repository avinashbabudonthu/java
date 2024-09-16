package com.test;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class EnumIssue {

    public static final String ADDRESS = "Test";

    public enum Employee {
        A("a", "d1", ADDRESS),
        B("b", "d1", ADDRESS);

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

        private Employee[] employees = Employee.values();
    }

    public static final Map<String, Employee> map = Maps.uniqueIndex(List.of(Employee.values()), Employee::getName);
    private Employee employee;
//    private String dept;

    public EnumIssue(Employee employee) {
        this.employee = employee;
//        this.dept = employee.getDept();
    }

    public static void main(String[] args) {
        EnumIssue enumIssue = new EnumIssue(Employee.A);
        System.out.println(enumIssue);
//        System.out.println(enumIssue.dept);
    }

}
