package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.wrappers.Methods;

public class SetterShouldBePublic extends PropertyMethodShouldBePublic {

    @Override
    protected String errorFormat() {
        return "Setter was not public: %s.";
    }

    @Override
    protected Methods getMethodsToTest(GetSetVerificationContext context) {
        return context.getMethods().setterMethods();
    }
}
