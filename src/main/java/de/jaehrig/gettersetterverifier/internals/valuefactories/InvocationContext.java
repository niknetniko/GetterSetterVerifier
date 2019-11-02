package de.jaehrig.gettersetterverifier.internals.valuefactories;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a InstantiationContextProvider
 * Created by nicojs on 8/21/2015.
 */
public class InvocationContext {

    private final Map<Class<?>, Object> complexObjects;

    public InvocationContext() {
        complexObjects = new HashMap<>();
    }

    public Map<Class<?>, Object> getComplexObjects() {
        return complexObjects;
    }

    public Object get(Class<?> clazz) {
        return complexObjects.get(clazz);
    }

    public void put(Class<?> clazz, Object object) {
        complexObjects.put(clazz, object);
    }
}
