package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidGetter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class ReturnTypeOfGetterTypeCheckTest {
    ReturnTypeOfGetterTypeCheck sut = new ReturnTypeOfGetterTypeCheck();

    @Test
    public void givenClassWithValidGetter_whenValidationIsExecuted_returnsSuccess() {
        var context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithGetterThatHasPolymorphousReturnTypeFromField_whenValidationIsExecuted_returnsFailure() {
        var context = VerificationContextBuilder.forClass(GetterWithSuperClassReturnTypeOfField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    static class GetterWithSuperClassReturnTypeOfField {
        private String something;

        public Object getSomething() {
            return something;
        }
    }

}
