package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidGetter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetterShouldBePublicTest {
    private GetterShouldBePublic sut = new GetterShouldBePublic();

    @Test
    public void givenClassWithPublicGetters_validationIsRun_validationSuccess() {
        var context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult result = sut.execute(context);

        assertThat(result.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithPrivateGetters_validationIsRun_validationFails() {
        var context = VerificationContextBuilder.forClass(PrivateGetter.class).build();

        VerificationResult result = sut.execute(context);

        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), containsString("getSomething"));
    }

    @Test
    public void givenClassWithProtectedGetters_validationIsRun_validationFails() {
        var context = VerificationContextBuilder.forClass(ProtectedGetter.class).build();

        VerificationResult result = sut.execute(context);

        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), containsString("getSomething"));
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class PrivateGetter {
        private String getSomething() {
            return "";
        }
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class ProtectedGetter {
        protected String getSomething() {
            return "";
        }
    }
}
