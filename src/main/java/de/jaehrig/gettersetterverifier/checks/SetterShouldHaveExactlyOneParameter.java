package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public class SetterShouldHaveExactlyOneParameter extends PropertyMethodParameterCount {
    private static final String ERROR_FORMAT = "Setters were found that have more or less than one parameter: %s";

    @Override
    protected <T> Methods methodsToTest(GetSetVerificationContext<T> context) {
        return context.getMethods().setterMethods();
    }

    @Override
    protected int parameterCount() {
        return 1;
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
