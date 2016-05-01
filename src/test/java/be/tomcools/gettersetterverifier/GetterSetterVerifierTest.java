package be.tomcools.gettersetterverifier;

import be.tomcools.gettersetterverifier.checks.examples.CompletelyValidClass;
import be.tomcools.gettersetterverifier.checks.examples.GetterThatDoesntReferenceField;
import be.tomcools.gettersetterverifier.checks.examples.LombokedClass;
import org.junit.Test;


public class GetterSetterVerifierTest {

    @Test
    public void givenCompletlyValidClass_whenVerified_verificationShouldSucceed() {
        GetterSetterVerifier
                .forClass(CompletelyValidClass.class)
                .verify();
    }

    @Test
    public void givenValidInnerClass_whenVerified_verificationShouldSucceed() {
        GetterSetterVerifier
                .forClass(CompletelyValidClass.InnerClass.class)
                .verify();
    }

    @Test
    public void givenLombokedClass_whenVerified_verificationShouldSucceed() {
        GetterSetterVerifier
                .forClass(LombokedClass.class)
                .verify();
    }

    @Test(expected = AssertionError.class)
    public void shouldFailValidation() {
        GetterSetterVerifier
                .forClass(GetterThatDoesntReferenceField.class)
                .verify();
    }
}