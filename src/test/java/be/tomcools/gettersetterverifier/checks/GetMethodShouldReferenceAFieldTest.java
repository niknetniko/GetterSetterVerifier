package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.VerificationContextBuilder;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.checks.examples.GetterThatDoesntReferenceField;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidGetter;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GetMethodShouldReferenceAFieldTest {

    private GetMethodShouldReferenceAField sut = new GetMethodShouldReferenceAField();

    @Test
    public void ifClassHasGetMethodThatDoesntReferenceAFieldVerificationFails() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(GetterThatDoesntReferenceField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    @Test
    public void ifClassHasGetMethodThatReferencesAFieldVerificationSucceeds() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void ifClassHasNoGetMethodThatReferencesAFieldVerificationSucceeds() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }
}