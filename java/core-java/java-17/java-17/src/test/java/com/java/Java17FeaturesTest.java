package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Java17FeaturesTest {

    /**
     * Pattern Matching for Switch (Preview) - JEP 406
     * <a href="https://openjdk.java.net/jeps/406">JEP 406</a>
     *
     * This is another step toward pattern matching by enhancing pattern matching for switch expressions
     * and statements.
     * It reduces the boilerplate necessary to define those expressions and
     * improves the expressiveness of the language
     */
    @Test
    public void switchCase() {
        String human = checkObject(new Human());
        log.info("human={}", human); // human=Ana's profession is princess
        String circle = checkObject(new Circle());
        log.info("circle={}", circle); // circle=It is circle com.java.Circle@523884b2
        String shape = checkObject(new Shape());
        log.info("shape={}", shape); // shape=Normal shape com.java.Shape@5b275dab

        String circle2 = checkShape(new Circle());
        log.info("circle2={}", circle2); // circle2=Good circle
        String triangle2 = checkShape(new Triangle());
        log.info("triangle2={}", triangle2); // triangle2=Normal shape

        String commaSeparatedCase1 = commaSeparatedCase("ONE");
        log.info("commaSeparatedCase1={}", commaSeparatedCase1); // commaSeparatedCase1=ONE OR TWO PLAYERS
        String commaSeparatedCase2 = commaSeparatedCase("THREE");
        log.info("commaSeparatedCase2={}", commaSeparatedCase2); // commaSeparatedCase2=THREE PLAYERS
        String commaSeparatedCase3 = commaSeparatedCase("FOUR");
        log.info("commaSeparatedCase3={}", commaSeparatedCase3); // commaSeparatedCase3=UNKNOWN NUMBER OF PLAYERS
    }

    private String checkObject(Object object) {
        return switch (object) {
            case Human h -> "%s's profession is %s".formatted(h.name(), h.profession());
            case Circle c -> "It is circle " + c;
            case Shape s -> "It is shape " + s;
            default -> "It is an object";
        };
    }

    private String checkShape(Shape shape) {
        return switch (shape) {
            case Triangle t && (t.getNumberOfSides() != 3) -> "Bad triangle";
            case Circle circle && circle.getNumberOfSides() == 0 -> "Good circle";
            default -> "Normal shape";
        };
    }

    private String commaSeparatedCase(String playersPerSide) {
        return switch (playersPerSide) {
            case "ONE", "TWO" -> {
                log.info("One or Two players");
                String result = "ONE OR TWO PLAYERS";
                yield result;
            }
            case "THREE" -> "THREE PLAYERS";
            default -> "UNKNOWN NUMBER OF PLAYERS";
        };
    }

    @Test
    public void recordDataType() {
        record Student(String name, Double grade){}
        Student student = new Student("Ana", 4.0);
        log.info("student={}", student); // student=Student[name=Ana, grade=4.0]
    }



}
