package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.wrappers.MethodDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

import java.lang.reflect.Modifier;

public abstract class PropertyMethodShouldBePublic extends GetterSetterCheck {
    protected abstract <T> Methods getMethodsToTest(GetSetVerificationContext<T> context);

    @Override
    public final <T> VerificationResult execute(GetSetVerificationContext<T> context) {
        Methods propertyMethods = getMethodsToTest(context);
        for (MethodDeclaration entry : propertyMethods) {
            if (!Modifier.isPublic(entry.getMethod().getModifiers())) {
                addFailure(entry.getName());
            }
        }

        return returnResult();
    }
}
