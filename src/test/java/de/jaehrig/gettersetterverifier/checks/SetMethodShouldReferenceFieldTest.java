package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.VerificationContextBuilder;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidGetter;
import de.jaehrig.gettersetterverifier.checks.examples.OnlyValidSetter;
import de.jaehrig.gettersetterverifier.checks.examples.SetterThatDoenstReferenceField;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class SetMethodShouldReferenceFieldTest {
    private SetMethodShouldReferenceField sut = new SetMethodShouldReferenceField();

    @Test
    public void ifClassHasSetMethodThatDoesntReferenceAFieldVerificationFails() {
        var context = VerificationContextBuilder.forClass(SetterThatDoenstReferenceField.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(false));
        assertThat(verificationResult.getMessage(), containsString("setSomething"));
    }

    @Test
    public void ifClassHasSetMethodThatReferencesAFieldVerificationSucceeds() {
        var context = VerificationContextBuilder.forClass(OnlyValidSetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }

    @Test
    public void ifClassHasNoSetMethodVerificationSucceeds() {
        var context = VerificationContextBuilder.forClass(OnlyValidGetter.class).build();

        VerificationResult verificationResult = sut.execute(context);
        assertThat(verificationResult.isSuccess(), is(true));
    }
}
