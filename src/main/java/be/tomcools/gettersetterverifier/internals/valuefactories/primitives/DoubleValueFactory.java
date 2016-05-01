package be.tomcools.gettersetterverifier.internals.valuefactories.primitives;

import be.tomcools.gettersetterverifier.internals.ValueFactory;

/**
 * Represents a DoubleValueFactory
 * Created by nicojs on 8/13/2015.
 */
public class DoubleValueFactory extends ValueFactory {
    private double seed = Double.MIN_VALUE;

    public DoubleValueFactory() {
        super(double.class);
    }

    @Override
    public Object next() {
        return seed++;
    }
}
