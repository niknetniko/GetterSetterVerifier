package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.VerificationContextBuilder;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidGetter;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GetterShouldNotHaveParameterTest {

    private GetterShouldNotHaveParameter sut = new GetterShouldNotHaveParameter();

    @Test
    public void givenClassWithValidGetter_whenValidationIsExecuted_returnsSuccess() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void givenClassWithParamterizedGetter_whenValidationIsExecuted_returnsFailure() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(GetterWithParameter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    class GetterWithParameter {
        private String something;

        public String getSomething(String someParameter) {
            return something;
        }
    }

}