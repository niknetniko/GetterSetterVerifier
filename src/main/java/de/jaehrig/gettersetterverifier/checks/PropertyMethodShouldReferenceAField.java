package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.helpers.JavaBeansNameParser;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.MethodDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public abstract class PropertyMethodShouldReferenceAField extends GetterSetterCheck {

    protected abstract <T> Methods getMethodsToTest(GetSetVerificationContext<T> context);

    @Override
    public final <T> VerificationResult execute(GetSetVerificationContext<T> context) {
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
