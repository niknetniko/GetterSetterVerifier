package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.wrappers.MethodDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Methods;

import java.lang.reflect.Modifier;

public abstract class PropertyMethodShouldBePublic extends GetterSetterCheck {
    protected abstract Methods getMethodsToTest(GetSetVerificationContext context);

    @Override
    public final VerificationResult execute(GetSetVerificationContext context) {
        Methods propertyMethods = getMethodsToTest(context);
        for (MethodDeclaration entry : propertyMethods) {
            if (!Modifier.isPublic(entry.getMethod().getModifiers())) {
                addFailure(entry.getName());
            }
        }

        return returnResult();
    }
}
