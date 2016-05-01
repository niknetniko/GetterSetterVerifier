package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.wrappers.SetterDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Setters;

public class SetterShouldHaveVoidReturnType extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Setter has a non-void return type: %s";

    @Override
    public VerificationResult execute(GetSetVerificationContext context) {
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
