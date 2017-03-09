package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.helpers.Instantiator;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.SetterDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Setters;
import de.jaehrig.gettersetterverifier.helpers.JavaBeansNameParser;

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

            String fieldOfSetter = JavaBeansNameParser.propertyMethodToField(setter.getName());

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
