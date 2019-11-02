package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidGetter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class GetterShouldRetrieveValueFromFieldTest {
    GetterShouldRetrieveValueFromField sut = new GetterShouldRetrieveValueFromField();

    @Test
    public void givenClassWithValidGetter_whenValidationIsExecuted_returnsSuccess() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithGetterThatReturnsNull_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(GetterReturnsNull.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    @Test
    public void givenClassWithGetterThatReturnsOtherFieldValue_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(GetterReturnsOtherField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    @Test
    public void ifClassHasFinalFieldAndGetterVerificationSucceeds() {
        GetSetVerificationContext<?> context = VerificationContextBuilder.forClass(FinalGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
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

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    static class FinalGetter {
        private final String value;

        FinalGetter(String value) {this.value = value;}

        public String getValue() {
            return value;
        }
    }
}
