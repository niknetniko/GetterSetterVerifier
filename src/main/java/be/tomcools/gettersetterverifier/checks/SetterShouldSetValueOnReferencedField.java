package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.helpers.Instantiator;
import be.tomcools.gettersetterverifier.wrappers.Fields;
import be.tomcools.gettersetterverifier.wrappers.SetterDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Setters;

import static be.tomcools.gettersetterverifier.helpers.JavaBeansNameParser.propertyMethodToField;

public class SetterShouldSetValueOnReferencedField extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Setter was found that doesn't affect the referenced field: %s.";

    @Override
    public VerificationResult execute(GetSetVerificationContext context) {
        Setters setters = context.getMethods().setters();
        Fields fields = context.getFields();

        for (SetterDeclaration setter : setters) {
            Object parameterObject = Instantiator.of(setter.getParameterType()).fromValueFactory();
            Object instance = context.newEmptyInstance();
            setter.invoke(instance, parameterObject);

            String fieldOfSetter = propertyMethodToField(setter.getName());

            Object fieldValue = fields.getFieldByName(fieldOfSetter).get(instance);
            if (fieldValue == null || !fieldValue.equals(parameterObject)) {
                addFailure(setter.getName());
            }
        }

        return returnResult();
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
