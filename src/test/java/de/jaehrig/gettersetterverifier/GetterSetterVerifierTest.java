package de.jaehrig.gettersetterverifier;

import de.jaehrig.gettersetterverifier.checks.Validations;
import de.jaehrig.gettersetterverifier.checks.examples.CompletelyValidClass;
import de.jaehrig.gettersetterverifier.checks.examples.GetterThatDoesntReferenceField;
import org.junit.Test;


public class GetterSetterVerifierTest {

    @Test
    public void givenCompletlyValidClass_whenVerified_verificationShouldSucceed() {
        GetterSetterVerifier
                .forClass(CompletelyValidClass.class)
                .excludeChecks(Validations.GETTER_SHOULD_BE_PUBLIC)
                .verify();
    }

    @Test
    public void givenValidInnerClass_whenVerified_verificationShouldSucceed() {
        GetterSetterVerifier
                .forClass(CompletelyValidClass.InnerClass.class)
                .verify();
    }

    @Test(expected = AssertionError.class)
    public void shouldFailValidation() {
        GetterSetterVerifier
                .forClass(GetterThatDoesntReferenceField.class)
                .verify();
    }
}
