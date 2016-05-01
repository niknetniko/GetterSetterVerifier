package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.wrappers.MethodDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Methods;

public abstract class PropertyMethodParameterCount extends GetterSetterCheck {

    protected abstract Methods methodsToTest(GetSetVerificationContext context);

    protected abstract int parameterCount();


    @Override
    public final VerificationResult execute(GetSetVerificationContext context) {
        Methods methods = methodsToTest(context);

        for (MethodDeclaration method : methods) {
            if (method.getParameterCount() != parameterCount()) {
                addFailure(method.getName());
            }
        }
        return returnResult();
    }
}
