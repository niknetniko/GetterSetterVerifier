package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetSetVerificationContext;
import de.jaehrig.gettersetterverifier.GetterSetterCheck;
import de.jaehrig.gettersetterverifier.VerificationResult;
import de.jaehrig.gettersetterverifier.helpers.JavaBeansNameParser;
import de.jaehrig.gettersetterverifier.wrappers.FieldDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.GetterDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Getters;

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
