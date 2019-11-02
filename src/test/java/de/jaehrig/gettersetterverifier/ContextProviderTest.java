package de.jaehrig.gettersetterverifier;

import java.util.Collections;
import java.util.List;

import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.Methods;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContextProviderTest {

    @Test
    public void givenValidClass_whenFieldsHaveBeenFiltered_excludesDefaultClassFields() {
        List<String> defaultClassFields = Collections.singletonList("class");
        VerificationContextBuilder<?> sut = VerificationContextBuilder.forClass(ValidGetterSetterUsage.class);

        Fields fieldsToTest = sut.determineFieldsToTest();

        for (String field : defaultClassFields) {
            assertThat(fieldsToTest.hasFieldWithName(field), is(false));
        }
    }

    @Test
    public void givenValidClass_whenFieldsHaveBeenFiltered_excludesDefaultInnerClassFields() {
        List<String> defaultInnerClassFields = Collections.singletonList("this$0");
        VerificationContextBuilder<?> sut = VerificationContextBuilder.forClass(ValidGetterSetterUsage.class);

        Fields fieldsToTest = sut.determineFieldsToTest();

        for (String field : defaultInnerClassFields) {
            assertThat(fieldsToTest.hasFieldWithName(field), is(false));
        }
    }

    @Test
    public void givenValidClass_whenMethodsHaveBeenFiltered_excludesDefaultClassMethods() {
        List<String> defaultClassFields = Collections.singletonList("getClass");
        VerificationContextBuilder<?> sut = VerificationContextBuilder.forClass(ValidGetterSetterUsage.class);

        Methods methodsToTest = sut.determineMethodsToTest();

        for (String method : defaultClassFields) {
            assertThat(methodsToTest.hasMethodWithName(method), is(false));
        }
    }

    @Test
    public void givenValidClass_whenFieldsHaveBeenExcluded_fieldsAreNotPresentInTheFieldsToTest() {
        String excluded = "somethingElse";
        VerificationContextBuilder<?> sut = VerificationContextBuilder.forClass(ValidGetterSetterUsage.class);
        sut.excludeField(excluded);

        Fields fieldsToTest = sut.determineFieldsToTest();
        assertThat(fieldsToTest.hasFieldWithName(excluded), is(false));
    }

    @Test
    public void givenValidClass_whenFieldsHaveBeenExcluded_fieldsGettersOrSettersAreNotPresentInTheMethodsToTest() {
        String excluded = "somethingElse";
        VerificationContextBuilder<?> sut = VerificationContextBuilder.forClass(ValidGetterSetterUsage.class);
        sut.excludeField(excluded);

        Methods methodsToTest = sut.determineMethodsToTest();
        assertThat(methodsToTest.hasMethodWithName("getSomethingElse"), is(false));
        assertThat(methodsToTest.hasMethodWithName("setSomethingElse"), is(false));
    }

    @Test
    public void givenValidClass_whenContextIsCreated_canGetNewEmtpyInstanceOfGivenClass() {
        GetSetVerificationContext<ValidGetterSetterUsage> sut = VerificationContextBuilder.forClass(ValidGetterSetterUsage.class).build();
        ValidGetterSetterUsage emptyInstance = sut.newEmptyInstance();

        assertThat(emptyInstance.getSomething(), is(nullValue()));
        assertThat(emptyInstance.getSomethingElse(), is(nullValue()));
    }

    @Test
    public void givenValidClass_whenContextIsCreated_canGetNewInitializedInstanceOfGivenClass() {
        GetSetVerificationContext<ValidGetterSetterUsage> sut = VerificationContextBuilder.forClass(ValidGetterSetterUsage.class).build();
        ValidGetterSetterUsage configuredInstance = sut.newConfiguredInstance();

        assertThat(configuredInstance.getSomething(), is(notNullValue()));
        assertThat(configuredInstance.getSomethingElse(), is(notNullValue()));
    }

    @SuppressWarnings("unused")
    static class ValidGetterSetterUsage {
        private String something;
        private String somethingElse;

        public String getSomething() {
            return something;
        }

        public String getSomethingElse() {
            return somethingElse;
        }

        public void setSomething(String something) {
            this.something = something;
        }

        public void setSomethingElse(String somethingElse) {
            this.somethingElse = somethingElse;
        }
    }

    @SuppressWarnings("unused")
    static class RandomGetter {
        private String something;
        private String somethingElse;

        public String getCrap() {
            return something;
        }
    }
}
