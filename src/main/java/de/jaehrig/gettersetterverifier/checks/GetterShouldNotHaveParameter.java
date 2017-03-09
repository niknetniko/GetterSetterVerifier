package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public class GetterShouldNotHaveParameter extends PropertyMethodParameterCount {
    private static final String ERROR_FORMAT = "Getters were found that have a parameter: %s";

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }

    @Override
    protected Methods methodsToTest(GetSetVerificationContext context) {
        return context.getMethods().getterMethods();
    }

    @Override
    protected int parameterCount() {
        return 0;
    }
}
