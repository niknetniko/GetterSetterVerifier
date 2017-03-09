package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetterShouldHaveExactlyOneParameterTest {

    private SetterShouldHaveExactlyOneParameter sut = new SetterShouldHaveExactlyOneParameter();

    @Test
    public void givenClassWithValidSetter_whenValidationIsExecuted_returnsSuccess() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithSetterThatHasMultipleParameters_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(SetterWithMoreThanOneParameter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    @Test
    public void givenClassWithSetterThatHasNoParameters_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(SetterWithNoParameters.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    class SetterWithNoParameters {
        private String something;

        public void setSomething() {
            this.something = "";
        }
    }

    class SetterWithMoreThanOneParameter {
        private String something;

        public void setSomething(String something, String somethingElse) {
            this.something = something;
        }
    }

}
