package de.jaehrig.gettersetterverifier.wrappers;

import de.jaehrig.gettersetterverifier.helpers.JavaBeansNameParser;

public class PropertyContextName {
    private final String fieldName;
    private final String setterName;
    private final String getterName;

    public PropertyContextName(String fieldName, String setterName, String getterName) {
        this.fieldName = fieldName;
        this.setterName = setterName;
        this.getterName = getterName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getSetterName() {
        return setterName;
    }

    public String getGetterName() {
        return getterName;
    }

    public static PropertyContextName fromFieldName(String fieldName) {
        String getter = JavaBeansNameParser.fieldToGetter(fieldName);
        String setter = JavaBeansNameParser.fieldToSetter(fieldName);
        return new PropertyContextName(fieldName, setter, getter);

    }
}
