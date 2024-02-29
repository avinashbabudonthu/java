package com.ab;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.*;
import org.xmlunit.matchers.CompareMatcher;

import javax.xml.transform.Source;

@Slf4j
class XmlUnitPractice {


    public static final String CONTROL_XML_1 = "<struct><int>3</int><boolean>false</boolean></struct>";
    public static final String CONTROL_XML_2 = "<a><b attr=\"abc\"></b></a>";

    private static final String CONTROL_XML_3 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><document xmlns=\"http://www.dtcc.com/DTCC/rds-1\"><testing1>testing1</testing1><submission><header><testing2>testing2</testing2></header></submission></document>";
    public static final String TEST_XML_1 = "<struct><int>3</int><boolean>false</boolean></struct>";

    public static final String TEST_XML_2 = "<struct><boolean>false</boolean><int>3</int></struct>";
    public static final String TEST_XML_3 = "<a><b attr=\"xyz\"></b></a>";

    public static final String TEST_XML_4 = "<a><b attr=\"abc\"></b></a>";

    public static final String TEST_XML_5 = "<a><b attr=\"abc\"></b><c></c></a>";

    private static final String TEST_XML_6 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><document xmlns=\"http://www.dtcc.com/DTCC/rds-1\"><testing3>testing3</testing3><submission><header><testing4>testing4</testing4></header></submission></document>";

    @Test
    void isIdenticalTo() {
        // assertThat(actual, matcher)
        MatcherAssert.assertThat(TEST_XML_1, CompareMatcher.isIdenticalTo(CONTROL_XML_1));
    }

    @Test
    void generateDifferences() {
        Diff diff = DiffBuilder.compare(CONTROL_XML_1).withTest(TEST_XML_2).build();
        Source controlSource = diff.getControlSource();
        log.info("controlSource.getSystemId() = {}", controlSource.getSystemId());

        Source testSource = diff.getTestSource();
        log.info("testSource.getSystemId() = {}", testSource.getSystemId());

        for (Difference difference : diff.getDifferences()) {
            log.info("diff--- {} ", difference.toString());
        }
    }

    @Test
    void customDifferenceEvaluator() {
        Diff myDiff = DiffBuilder.compare(CONTROL_XML_3).withTest(TEST_XML_6)
                .withDifferenceEvaluator(new IgnoreAttributeDifferenceEvaluator("attr"))
                .checkForSimilar().build();

        log.info("myDiff.toString( = {}", myDiff.toString());
        Assertions.assertFalse(myDiff.hasDifferences());
    }

    private static class IgnoreAttributeDifferenceEvaluator implements DifferenceEvaluator {
        private String attributeName;
        public IgnoreAttributeDifferenceEvaluator(String attributeName) {
            this.attributeName = attributeName;
        }

        @Override
        public ComparisonResult evaluate(Comparison comparison, ComparisonResult outcome) {
            if (outcome == ComparisonResult.EQUAL)
                return outcome;

            ComparisonType comparisonType = comparison.getType();

            if(ComparisonType.CHILD_NODELIST_LENGTH.equals(comparisonType)) {
                return ComparisonResult.SIMILAR;
            }

            final Node controlNode = comparison.getControlDetails().getTarget();
            final Node testNode = comparison.getTestDetails().getTarget();

            if (controlNode instanceof Attr) {
                Attr attr = (Attr) controlNode;
                if (attr.getName().equals(attributeName)) {
                    return ComparisonResult.SIMILAR;
                }
            }

            if(testNode.getNodeName().equalsIgnoreCase("c")) {
                return ComparisonResult.SIMILAR;
            }

            return outcome;
        }
    }

}
