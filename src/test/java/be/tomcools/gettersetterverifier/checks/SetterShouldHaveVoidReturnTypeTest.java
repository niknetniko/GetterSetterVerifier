package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.VerificationContextBuilder;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetterShouldHaveVoidReturnTypeTest {

    private SetterShouldHaveVoidReturnType sut = new SetterShouldHaveVoidReturnType();

    @Test
    public void givenClassWithValidSetter_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);

        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithSetterThatReturnsValue_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(SetterWithReturnType.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    class SetterWithReturnType {
        private String something;

        public String setSomething(String something) {
            this.something = something;
            return this.something;
        }
    }


}