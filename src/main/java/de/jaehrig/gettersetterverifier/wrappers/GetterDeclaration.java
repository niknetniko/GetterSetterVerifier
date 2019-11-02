package de.jaehrig.gettersetterverifier.wrappers;

import de.jaehrig.gettersetterverifier.exceptions.VerificationExecutionException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetterDeclaration extends MethodDeclaration {
    public GetterDeclaration(String name, Method method) {
        super(name, method);
    }

    public Object invoke(Object instance) {
        Object returnedObject;
        boolean accessible = getMethod().canAccess(instance);

        getMethod().setAccessible(true);
        try {
            returnedObject = getMethod().invoke(instance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new VerificationExecutionException("Error while invoking getter method: " + getName(), e);
        }
        getMethod().setAccessible(accessible);

        return returnedObject;
    }
}
