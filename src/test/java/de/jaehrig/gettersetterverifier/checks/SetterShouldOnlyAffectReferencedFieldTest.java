package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class SetterShouldOnlyAffectReferencedFieldTest {
    private SetterShouldOnlyAffectReferencedField sut = new SetterShouldOnlyAffectReferencedField();

    @Test
    public void givenClassWithValidSetter_whenValidationIsExecuted_returnsSuccess() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithSetterThatChangesOtherField_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(SetterChangesOtherField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    static class SetterChangesOtherField {
        private String something;
        private String somethingElse;

        public void setSomething(String something) {
            this.somethingElse = something;
        }
    }

}
