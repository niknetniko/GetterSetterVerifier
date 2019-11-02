package de.jaehrig.gettersetterverifier.internals.valuefactories.primitives;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;

/**
 * Represents a DoubleValueFactory
 * Created by nicojs on 8/13/2015.
 */
public class DoubleValueFactory extends ValueFactory<Double> {
    private double seed = Double.MIN_VALUE;

    public DoubleValueFactory() {
        super(double.class);
    }

    @Override
    public Double next() {
        return seed++;
    }
}
