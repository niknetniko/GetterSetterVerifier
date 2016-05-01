package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.VerificationContextBuilder;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetterShouldOnlyAffectReferencedFieldTest {
    private SetterShouldOnlyAffectReferencedField sut = new SetterShouldOnlyAffectReferencedField();

    @Test
    public void givenClassWithValidSetter_whenValidationIsExecuted_returnsSuccess() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithSetterThatChangesOtherField_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(SetterChangesOtherField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    class SetterChangesOtherField {
        private String something;
        private String somethingElse;

        public void setSomething(String something) {
            this.somethingElse = something;
        }
    }

}