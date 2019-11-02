package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public class SetMethodShouldReferenceField extends PropertyMethodShouldReferenceAField {

    @Override
    protected String errorFormat() {
        return "Setters were found that do not reference a field: %s";
    }

    @Override
    protected <T> Methods getMethodsToTest(GetSetVerificationContext<T> context) {
        return context.getMethods().setterMethods();
    }
}
