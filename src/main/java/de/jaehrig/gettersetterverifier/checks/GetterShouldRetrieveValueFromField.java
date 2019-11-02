package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.GetterDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Getters;

import de.jaehrig.gettersetterverifier.helpers.JavaBeansNameParser;
import java.util.Objects;

public class GetterShouldRetrieveValueFromField extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Getters were found that do not return the field value: %s.";

    @Override
    public <T> VerificationResult execute(GetSetVerificationContext<T> context) {
        Getters getters = context.getMethods().getters();
        Fields fields = context.getFields();

        for (GetterDeclaration getter : getters) {
            Object instance = context.newConfiguredInstance();
            Object getterValue = getter.invoke(instance);

            String fieldOfGetter = JavaBeansNameParser.propertyMethodToField(getter.getName());
            Object fieldValue = fields.getFieldByName(fieldOfGetter).get(instance);
            if (!Objects.equals(getterValue, fieldValue)) {
                addFailure(getter.getName());
            }
        }

        return returnResult();
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
