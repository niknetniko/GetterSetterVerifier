package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidGetter;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GetterShouldRetrieveValueFromFieldTest {
    GetterShouldRetrieveValueFromField sut = new GetterShouldRetrieveValueFromField();

    @Test
    public void givenClassWithValidGetter_whenValidationIsExecuted_returnsSuccess() {
        var context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithGetterThatReturnsNull_whenValidationIsExecuted_returnsFailure() {
        var context = VerificationContextBuilder.forClass(GetterReturnsNull.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    @Test
    public void givenClassWithGetterThatReturnsOtherFieldValue_whenValidationIsExecuted_returnsFailure() {
        var context = VerificationContextBuilder.forClass(GetterReturnsOtherField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class GetterReturnsNull {
        private String something;

        public String getSomething() {
            return null;
        }
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class GetterReturnsOtherField {
        private String something;
        private String somethingElse;

        public String getSomething() {
            return somethingElse;
        }
    }
}
