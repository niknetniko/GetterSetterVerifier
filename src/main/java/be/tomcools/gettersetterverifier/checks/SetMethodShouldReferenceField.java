package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.wrappers.Methods;

public class SetMethodShouldReferenceField extends PropertyMethodShouldReferenceAField {
    private final String ERROR_FORMAT = "Setters were found that do not reference a field: %s";

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }

    @Override
    protected Methods getMethodsToTest(GetSetVerificationContext context) {
        return context.getMethods().setterMethods();
    }
}
