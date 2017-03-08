package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.wrappers.Fields;
import be.tomcools.gettersetterverifier.wrappers.GetterDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Getters;

import java.util.Objects;

import static be.tomcools.gettersetterverifier.helpers.JavaBeansNameParser.propertyMethodToField;

public class GetterShouldRetrieveValueFromField extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Getters were found that do not return the field value: %s.";

    @Override
    public VerificationResult execute(GetSetVerificationContext context) {
        Getters getters = context.getMethods().getters();
        Fields fields = context.getFields();

        for (GetterDeclaration getter : getters) {
            Object instance = context.newConfiguredInstance();
            Object getterValue = getter.invoke(instance);

            String fieldOfGetter = propertyMethodToField(getter.getName());
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
