package be.tomcools.gettersetterverifier.internals.valuefactories.primitives;

import be.tomcools.gettersetterverifier.internals.ValueFactory;

/**
 * Represents a ShortValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class ShortValueFactory extends ValueFactory<Short> {

    private short seed = Short.MIN_VALUE;

    public ShortValueFactory() {
        super(short.class);
    }

    @Override
    public Short next() {
        return seed++;
    }
}
