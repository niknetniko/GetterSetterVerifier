package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.wrappers.MethodDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public abstract class PropertyMethodParameterCount extends GetterSetterCheck {

    protected abstract <T> Methods methodsToTest(GetSetVerificationContext<T> context);

    protected abstract int parameterCount();


    @Override
    public final <T> VerificationResult execute(GetSetVerificationContext<T> context) {
        Methods methods = methodsToTest(context);

        for (MethodDeclaration method : methods) {
            if (method.getParameterCount() != parameterCount()) {
                addFailure(method.getName());
            }
        }
        return returnResult();
    }
}
