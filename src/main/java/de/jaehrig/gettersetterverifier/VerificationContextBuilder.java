package de.jaehrig.gettersetterverifier;

import de.jaehrig.gettersetterverifier.wrappers.FieldDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.Methods;
import de.jaehrig.gettersetterverifier.wrappers.PropertyContextName;
import de.jaehrig.gettersetterverifier.wrappers.PropertyContextNames;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class VerificationContextBuilder<T> {
    private static List<String> defaultExcludedFields = Arrays.asList("class", "this$0");
    private PropertyContextNames excludedProperties = fillDefaultExcludedProperties();
    private Class<T> classToTest;

    VerificationContextBuilder(Class<T> classToTest) {
        this.classToTest = classToTest;
    }

    public static <T> VerificationContextBuilder<T> forClass(Class<T> tClass) {
        return new VerificationContextBuilder<>(tClass);
    }

    public GetSetVerificationContext<T> build() {
        return GetSetVerificationContext.builder(classToTest)
                .fields(determineFieldsToTest())
                .methods(determineMethodsToTest())
                .build();
    }

    private static PropertyContextNames fillDefaultExcludedProperties() {
        PropertyContextNames excludedProperties = new PropertyContextNames();
        for (String excludedField : defaultExcludedFields) {
            excludedProperties.add(PropertyContextName.fromFieldName(excludedField));
        }
        return excludedProperties;
    }

    Fields determineFieldsToTest() {
        Fields filteredFields = new Fields();
        Field[] declaredFields = classToTest.getDeclaredFields();
        for (Field field : declaredFields) {
            if (!excludedProperties.fieldNames().contains(field.getName())) {
                filteredFields.put(field.getName(), new FieldDeclaration(field.getName(), field));
            }
        }
        return filteredFields;
    }

    Methods determineMethodsToTest() {
        Methods filteredMethods = new Methods();
        Method[] methods = classToTest.getDeclaredMethods();
        for (Method descriptor : methods) {
            if (descriptor.getName().startsWith("get") || descriptor.getName().startsWith("set"))
                addMethodIfNotNullOrExcluded(filteredMethods, descriptor);
        }
        return filteredMethods;
    }

    private void addMethodIfNotNullOrExcluded(Methods filteredMethods, Method method) {
        if (method != null && !excludedProperties.methodNames().contains(method.getName())) {
            filteredMethods.put(method.getName(), method);
        }
    }

    public VerificationContextBuilder<T> excludeField(String fieldName) {
        excludedProperties.add(PropertyContextName.fromFieldName(fieldName));
        return this;
    }
}
