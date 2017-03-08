package be.tomcools.gettersetterverifier.internals;


/**
 * Represents a ValueFactory
 * Created by nicojs on 8/12/2015.
 */
public abstract class ValueFactory<T> {

    private final Class<T> targetClass;

    public ValueFactory(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public abstract T next();

    public Class<T> getTargetClass() {
        return targetClass;
    }
}
