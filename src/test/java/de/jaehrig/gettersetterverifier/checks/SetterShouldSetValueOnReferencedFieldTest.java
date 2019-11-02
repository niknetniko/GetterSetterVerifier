package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetterShouldSetValueOnReferencedFieldTest {
    private SetterShouldSetValueOnReferencedField sut = new SetterShouldSetValueOnReferencedField();

    @Test
    public void givenClassWithValidSetter_whenValidationIsExecuted_returnsSuccess() {
        var context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithSetterThatPutsDifferentValueOnField_whenValidationIsExecuted_returnsFailure() {
        var context = VerificationContextBuilder.forClass(SetterPutsDifferentValueOnField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    @Test
    public void givenClassWithSetterThatPutsNullValueOnField_whenValidationIsExecuted_returnsFailure() {
        var context = VerificationContextBuilder.forClass(SetterPutsNullValueOnField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    static class SetterPutsDifferentValueOnField {
        private String something;

        public void setSomething(String something) {
            this.something = "Something Totally Different";
        }
    }

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    static class SetterPutsNullValueOnField {
        private String something;

        public void setSomething(String something) {
            this.something = null;
        }
    }

}
