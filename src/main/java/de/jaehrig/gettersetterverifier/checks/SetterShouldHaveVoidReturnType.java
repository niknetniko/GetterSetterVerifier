package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.wrappers.SetterDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Setters;

public class SetterShouldHaveVoidReturnType extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Setter has a non-void return type: %s";

    @Override
    public <T> VerificationResult execute(GetSetVerificationContext<T> context) {
        Setters setters = context.getMethods().setters();
        for (SetterDeclaration setter : setters) {
            if (setter.getReturnType() != void.class) {
                addFailure(setter.getName());
            }
        }
        return returnResult();
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
