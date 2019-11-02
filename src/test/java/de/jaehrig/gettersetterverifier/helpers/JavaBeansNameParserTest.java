package de.jaehrig.gettersetterverifier.helpers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JavaBeansNameParserTest {

    @Test
    public void fieldToGetter_givenFieldName_createsTheCorrectGetterName() {
        String field = "fieldName";
        String expectedGetter = "getFieldName";

        String getter = JavaBeansNameParser.fieldToGetter(field);
        assertThat(getter, is(expectedGetter));
    }

    @Test
    public void fieldToSetter_givenFieldName_createsTheCorrectSetterName() {
        String field = "fieldName";
        String expectedSetter = "setFieldName";

        String setter = JavaBeansNameParser.fieldToSetter(field);
        assertThat(setter, is(expectedSetter));
    }

    @Test
    public void propertyMethodToField_givenSetterName_createsTheCorrectFieldName() {
        String expectedField = "fieldName";
        String setter = "setFieldName";

        assertMethodToField(setter, expectedField);
    }

    @Test
    public void propertyMethodToField_givenGetterName_createsTheCorrectFieldName() {
        String expectedField = "fieldName";
        String getter = "getFieldName";

        assertMethodToField(getter, expectedField);
    }

    private void assertMethodToField(String methodName, String expectedFieldName) {
        String field = JavaBeansNameParser.propertyMethodToField(methodName);
        assertThat(field, is(expectedFieldName));
    }
}
