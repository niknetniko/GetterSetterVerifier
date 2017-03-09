package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.wrappers.MethodDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

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
