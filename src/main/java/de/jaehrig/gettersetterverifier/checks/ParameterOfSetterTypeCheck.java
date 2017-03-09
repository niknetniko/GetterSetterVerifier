package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.helpers.JavaBeansNameParser;
import de.jaehrig.gettersetterverifier.wrappers.FieldDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.SetterDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Setters;

public class ParameterOfSetterTypeCheck extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Parameter of setter was not the same type as the referenced field: %s";

    @Override
    public VerificationResult execute(GetSetVerificationContext context) {
        Setters setters = context.getMethods().setters();
        Fields fields = context.getFields();

        for (SetterDeclaration entry : setters) {
            String expectedFieldName = JavaBeansNameParser.propertyMethodToField(entry.getName());
            FieldDeclaration field = fields.getFieldByName(expectedFieldName);
            if (field.getType() != entry.getParameterType()) {
                addFailure(entry.getName());
            }
        }

        return returnResult();
    }

    @Override
    protected String errorFormat() {
        return ERROR_FORMAT;
    }
}
