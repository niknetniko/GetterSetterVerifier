package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.helpers.Instantiator;
import de.jaehrig.gettersetterverifier.wrappers.FieldDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.SetterDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Setters;
import de.jaehrig.gettersetterverifier.helpers.JavaBeansNameParser;

public class SetterShouldOnlyAffectReferencedField extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Setter was found that affects field different than referenced field: %s.";

    @Override
    public <T> VerificationResult execute(GetSetVerificationContext<T> context) {
        Setters setters = context.getMethods().setters();
        for (SetterDeclaration setter : setters) {
            Object parameterObject = Instantiator.of(setter.getParameterType()).fromValueFactory();
            Object instance = context.newEmptyInstance();
            setter.invoke(instance, parameterObject);

            String fieldOfSetter = JavaBeansNameParser.propertyMethodToField(setter.getName());
            boolean wasOtherFieldChanged = wasOtherFieldChanged(context.getFields(), fieldOfSetter, instance);

            if (wasOtherFieldChanged) {
                addFailure(setter.getName());
            }
        }

        return returnResult();
    }

    private boolean wasOtherFieldChanged(Fields fields, String changedFieldName, Object instance) {
        for (FieldDeclaration field : fields) {
            // Skip fields we changed.
            if (!field.getName().equals(changedFieldName)) {
                Object fieldValue = field.get(instance);
                if (!isDefault(fieldValue, field)) {
                    return true;    // failure
                }
            }
        }
        return false; //success
    }

    private boolean isDefault(Object value, FieldDeclaration field) {
        return boolean.class.equals(field.getType()) && Boolean.FALSE.equals(value)
                || char.class.equals(field.getType()) && Character.MIN_VALUE == (char) value
                || field.getType().isPrimitive() && ((Number) value).doubleValue() == 0
                || !field.getType().isPrimitive() && value == null;
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
