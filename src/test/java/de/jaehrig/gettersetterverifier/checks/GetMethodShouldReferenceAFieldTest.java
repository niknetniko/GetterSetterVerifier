package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.GetterThatDoesntReferenceField;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidGetter;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidSetter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GetMethodShouldReferenceAFieldTest {

    private GetMethodShouldReferenceAField sut = new GetMethodShouldReferenceAField();

    @Test
    public void ifClassHasGetMethodThatDoesntReferenceAFieldVerificationFails() {
        var context = VerificationContextBuilder.forClass(GetterThatDoesntReferenceField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("getSomething"));
    }

    @Test
    public void ifClassHasGetMethodThatReferencesAFieldVerificationSucceeds() {
        var context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void ifClassHasNoGetMethodThatReferencesAFieldVerificationSucceeds() {
        var context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }
}
