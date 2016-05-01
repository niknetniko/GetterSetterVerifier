package be.tomcools.gettersetterverifier.checks;

import be.tomcools.gettersetterverifier.GetSetVerificationContext;
import be.tomcools.gettersetterverifier.GetterSetterCheck;
import be.tomcools.gettersetterverifier.VerificationResult;
import be.tomcools.gettersetterverifier.helpers.JavaBeansNameParser;
import be.tomcools.gettersetterverifier.wrappers.FieldDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Fields;
import be.tomcools.gettersetterverifier.wrappers.GetterDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Getters;

public class ReturnTypeOfGetterTypeCheck extends GetterSetterCheck {
    private static final String ERROR_FORMAT = "Return Type of getter was not the same type as the referenced field: %s";

    @Override
    public VerificationResult execute(GetSetVerificationContext context) {
        Getters getters = context.getMethods().getters();
        Fields fields = context.getFields();

        for (GetterDeclaration getter : getters) {
            String expectedFieldName = JavaBeansNameParser.propertyMethodToField(getter.getName());
            FieldDeclaration field = fields.getFieldByName(expectedFieldName);
            if (field.getType() != getter.getReturnType()) {
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
