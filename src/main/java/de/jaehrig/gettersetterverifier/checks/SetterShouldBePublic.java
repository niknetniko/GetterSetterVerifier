package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public class SetterShouldBePublic extends PropertyMethodShouldBePublic {

    @Override
    protected String errorFormat() {
        return "Setter was not public: %s.";
    }

    @Override
    protected <T> Methods getMethodsToTest(GetSetVerificationContext<T> context) {
        return context.getMethods().setterMethods();
    }
}
