package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SetterShouldHaveVoidReturnTypeTest {

    private SetterShouldHaveVoidReturnType sut = new SetterShouldHaveVoidReturnType();

    @Test
    public void givenClassWithValidSetter_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);

        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithSetterThatReturnsValue_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(SetterWithReturnType.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class SetterWithReturnType {
        private String something;

        public String setSomething(String something) {
            this.something = something;
            return this.something;
        }
    }


}
