package de.jaehrig.gettersetterverifier.internals.valuefactories.primitives;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;

/**
 * Represents a LongValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class LongValueFactory extends ValueFactory<Long> {

    public long seed = Long.MIN_VALUE;

    public LongValueFactory() {
        super(long.class);
    }

    @Override
    public Long next() {
        return seed++;
    }
}
