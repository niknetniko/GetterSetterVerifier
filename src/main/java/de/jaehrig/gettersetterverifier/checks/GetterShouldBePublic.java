package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public class GetterShouldBePublic extends PropertyMethodShouldBePublic {
    private static final String ERROR_FORMAT = "Getter was not public: %s.";

    @Override
    protected <T> Methods getMethodsToTest(GetSetVerificationContext<T> context) {
        return context.getMethods().getterMethods();
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
