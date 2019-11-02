package de.jaehrig.gettersetterverifier.internals;

import de.jaehrig.gettersetterverifier.internals.valuefactories.ComplexObjectValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.EnumValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.InvocationContext;

import java.util.HashMap;
import java.util.Map;

public class ValueFactories {

    private final static Map<Class<?>, Class<?>> SIMPLIFICATION_MAP;
    private final InvocationContext context;

    static {
        SIMPLIFICATION_MAP = new HashMap<>();
        SIMPLIFICATION_MAP.put(Boolean.class, boolean.class);
        SIMPLIFICATION_MAP.put(Byte.class, byte.class);
        SIMPLIFICATION_MAP.put(Character.class, char.class);
        SIMPLIFICATION_MAP.put(Double.class, double.class);
        SIMPLIFICATION_MAP.put(Float.class, float.class);
        SIMPLIFICATION_MAP.put(Integer.class, int.class);
        SIMPLIFICATION_MAP.put(Long.class, long.class);
        SIMPLIFICATION_MAP.put(Short.class, short.class);
    }

    private Map<Class<?>, ValueFactory<?>> factoryMap;

    public ValueFactories() {
        factoryMap = new HashMap<>();
        context = new InvocationContext();
    }

    public <T> ValueFactory<?> get(Class<T> clazz) {
        Class<?> simplifiedClass = simplify(clazz);
        ValueFactory<?> valueFactory = factoryMap.get(simplifiedClass);
        if (valueFactory == null) {
            if (simplifiedClass.isEnum()) {
                valueFactory = new EnumValueFactory<>(simplifiedClass);
            } else {
                valueFactory = new ComplexObjectValueFactory<>(simplifiedClass, this, context);
            }
            factoryMap.put(simplifiedClass, valueFactory);
        }
        return valueFactory;
    }

    private Class<?> simplify(Class<?> clazz) {
        Class<?> simpleClass = SIMPLIFICATION_MAP.get(clazz);
        if (simpleClass == null) {
            simpleClass = clazz;
        }
        return simpleClass;
    }

    @SuppressWarnings("unchecked")
    public <T> T provideNextValue(Class<T> clazz) {
        return (T) get(clazz).next();
    }

    public void putIfNotExists(ValueFactory<?>... valueFactories) {
        for (ValueFactory<?> valueFactory : valueFactories) {
            factoryMap.putIfAbsent(valueFactory.getTargetClass(), valueFactory);
        }
    }
}
