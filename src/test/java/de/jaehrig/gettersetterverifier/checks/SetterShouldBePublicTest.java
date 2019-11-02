package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SetterShouldBePublicTest {
    private SetterShouldBePublic sut = new SetterShouldBePublic();

    @Test
    public void givenClassWithPublicGetters_validationIsRun_validationSuccess() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult result = sut.execute(context);

        assertThat(result.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithPrivateGetters_validationIsRun_validationFails() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(PrivateSetter.class).build();

        VerificationResult result = sut.execute(context);

        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), containsString("setSomething"));
    }

    @Test
    public void givenClassWithProtectedGetters_validationIsRun_validationFails() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(ProtectedSetter.class).build();

        VerificationResult result = sut.execute(context);

        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), containsString("setSomething"));
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class PrivateSetter {
        private void setSomething(String set) {
        }
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class ProtectedSetter {
        protected void setSomething(String set) {
        }
    }

}
