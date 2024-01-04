package com.ab.java.lang;

import org.junit.Test;

public class RuntimeVersionPractice {
  
   /**
     * Running with Java 9.0.4
     * Output:
     * major: 9
     * minor: 0
     * security: 4
     * build: Optional[11]
     * version: [9, 0, 4]
     */
  @Test
    public void version(){
        Runtime.Version version = Runtime.version();
        System.out.println("major: "+version.major());
        System.out.println("minor: "+version.minor());
        System.out.println("security: "+version.security());
        System.out.println("build: "+version.build());
        System.out.println("version: "+version.version());
    }
  
}
