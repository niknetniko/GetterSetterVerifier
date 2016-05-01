package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.helpers.Instantiator;
import be.tomcools.gettersetterverifier.wrappers.FieldDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Fields;
import be.tomcools.gettersetterverifier.wrappers.SetterDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Setters;

import static be.tomcools.gettersetterverifier.helpers.JavaBeansNameParser.propertyMethodToField;

public class SetterShouldOnlyAffectReferencedField extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Setter was found that affects field different than referenced field: %s.";

    @Override
    public VerificationResult execute(GetSetVerificationContext context) {
        Setters setters = context.getMethods().setters();
        for (SetterDeclaration setter : setters) {
            Object parameterObject = Instantiator.of(setter.getParameterType()).instantiate();
            Object instance = context.newEmptyInstance();
            setter.invoke(instance, parameterObject);

            String fieldOfSetter = propertyMethodToField(setter.getName());
            boolean wasOtherFieldChanged = wasOtherFieldChanged(context.getFields(), fieldOfSetter, instance);

            if (wasOtherFieldChanged) {
                addFailure(setter.getName());
            }
        }

        return returnResult();
    }

    private boolean wasOtherFieldChanged(Fields fields, String changedFieldName, Object instance) {
        for (FieldDeclaration field : fields) {
            if (field.getName().equals(changedFieldName)) {
                //skip, because it was the field we changed
            } else {
                Object fieldValue = field.get(instance);
                if (fieldValue != null) {
                    return true;    // failure
                }
            }
        }
        return false; //success
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
