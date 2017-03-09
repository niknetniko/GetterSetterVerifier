package de.jaehrig.gettersetterverifier.internals;

/**
 * Represents a Provider
 * Created by nicojs on 8/15/2015.
 */
public interface Producer<T> {
    T produce();
}
