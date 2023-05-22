package com.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NestBasedAccessControl {

    public class Inner{}

    /**
     * Output:
     * true
     * true
     * [com.java.NestBasedAccessControl, com.java.NestBasedAccessControl$Inner]
     *
     */
    public static void main(String[] args) {
        boolean isNestMate = NestBasedAccessControl.class.isNestmateOf(NestBasedAccessControl.Inner.class);
        boolean nestHost = NestBasedAccessControl.Inner.class.getNestHost() == NestBasedAccessControl.class;

        System.out.println(isNestMate);
        System.out.println(nestHost);

        Set<String> nestedMembers = Arrays.stream(NestBasedAccessControl.Inner.class.getNestMembers())
                .map(Class::getName)
                .collect(Collectors.toSet());
        System.out.println(nestedMembers);
    }
}
