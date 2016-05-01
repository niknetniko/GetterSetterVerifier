package be.tomcools.gettersetterverifier.internals.valuefactories.primitives;

import be.tomcools.gettersetterverifier.internals.ValueFactory;

/**
 * Represents a FloatValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class FloatValueFactory extends ValueFactory<Float> {
    private float seed = Float.MIN_VALUE;

    public FloatValueFactory() {
        super(float.class);
    }

    @Override
    public Float next() {
        return seed++;
    }
}
