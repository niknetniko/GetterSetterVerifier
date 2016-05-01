package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.helpers.JavaBeansNameParser;
import be.tomcools.gettersetterverifier.wrappers.Fields;
import be.tomcools.gettersetterverifier.wrappers.MethodDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Methods;

public abstract class PropertyMethodShouldReferenceAField extends GetterSetterCheck {

    protected abstract Methods getMethodsToTest(GetSetVerificationContext context);

    @Override
    public final VerificationResult execute(GetSetVerificationContext context) {
        Fields fields = context.getFields();
        Methods methodsToTest = getMethodsToTest(context);

        for (MethodDeclaration entry : methodsToTest) {
            String expectedFieldName = JavaBeansNameParser.propertyMethodToField(entry.getName());
            if (!fields.hasFieldWithName(expectedFieldName)) {
                addFailure(entry.getName());
            }
        }

        return returnResult();
    }
}
