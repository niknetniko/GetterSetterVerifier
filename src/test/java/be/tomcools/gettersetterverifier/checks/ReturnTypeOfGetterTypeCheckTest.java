package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.VerificationContextBuilder;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidGetter;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReturnTypeOfGetterTypeCheckTest {
    ReturnTypeOfGetterTypeCheck sut = new ReturnTypeOfGetterTypeCheck();

    @Test
    public void givenClassWithValidGetter_whenValidationIsExecuted_returnsSuccess() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithGetterThatHasPolymorphousReturnTypeFromField_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(GetterWithSuperClassReturnTypeOfField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    class GetterWithSuperClassReturnTypeOfField {
        private String something;

        public Object getSomething() {
            return something;
        }
    }

}