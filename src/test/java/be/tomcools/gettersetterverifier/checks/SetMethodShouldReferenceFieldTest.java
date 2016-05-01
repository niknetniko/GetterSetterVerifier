package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.VerificationContextBuilder;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidGetter;
import be.tomcools.gettersetterverifier.checks.examples.OnlyValidSetter;
import be.tomcools.gettersetterverifier.checks.examples.SetterThatDoenstReferenceField;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetMethodShouldReferenceFieldTest {
    private SetMethodShouldReferenceField sut = new SetMethodShouldReferenceField();

    @Test
    public void ifClassHasSetMethodThatDoesntReferenceAFieldVerificationFails() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(SetterThatDoenstReferenceField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    @Test
    public void ifClassHasSetMethodThatReferencesAFieldVerificationSucceeds() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void ifClassHasNoSetMethodVerificationSucceeds() {
        GetSetVerificationContext context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }
}