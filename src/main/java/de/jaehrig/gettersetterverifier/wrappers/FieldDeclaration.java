package de.jaehrig.gettersetterverifier.wrappers;

import de.jaehrig.gettersetterverifier.exceptions.VerificationExecutionException;

import java.lang.reflect.Field;

public class FieldDeclaration {
    private final String name;
    private final Field field;

    public FieldDeclaration(String name, Field field) {
        this.name = name;
        this.field = field;
    }

    public Class<?> getType() {
        return field.getType();
    }

    public Object get(Object instance) {
        Object fieldValue;
        @SuppressWarnings("deprecation")
        boolean accessible = field.isAccessible();

        field.setAccessible(true);
        try {
            fieldValue = field.get(instance);
        } catch (IllegalAccessException e) {
            throw new VerificationExecutionException("Error while getting field: " + field.getName(), e);
        } finally {
            field.setAccessible(accessible);
        }
        return fieldValue;
    }

    public void set(Object instance, Object fieldValue) {
        @SuppressWarnings("deprecation")
        boolean accessible = field.isAccessible();

        field.setAccessible(true);
        try {
            field.set(instance, fieldValue);
        } catch (IllegalAccessException e) {
            throw new VerificationExecutionException("Error while setting field: " + field.getName(), e);
        } finally {
            field.setAccessible(accessible);
        }
    }

    public String getName() {
        return name;
    }

    public Field getField() {
        return field;
    }
}
