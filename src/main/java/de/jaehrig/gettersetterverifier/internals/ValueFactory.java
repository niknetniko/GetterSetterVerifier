package de.jaehrig.gettersetterverifier.internals;


import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ValueFactory
 * Created by nicojs on 8/12/2015.
 */
public abstract class ValueFactory<T> {

    private final Class<T> targetClass;

    public ValueFactory(TypeLiteral<T> literal) {
        this(literal.getRawType());
    }

    public ValueFactory(Class<T> clazz) {
        this.targetClass = clazz;
    }

    public abstract T next();

    public Class<T> getTargetClass() {
        return targetClass;
    }
}
