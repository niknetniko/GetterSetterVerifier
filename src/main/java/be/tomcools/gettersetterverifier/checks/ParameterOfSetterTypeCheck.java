package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.helpers.JavaBeansNameParser;
import be.tomcools.gettersetterverifier.wrappers.FieldDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Fields;
import be.tomcools.gettersetterverifier.wrappers.SetterDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Setters;

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
