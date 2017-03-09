package de.jaehrig.gettersetterverifier.internals.valuefactories.primitives;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;

/**
 * Represents a IntValueFactory
 * Created by nicojs on 8/13/2015.
 */
public class IntValueFactory extends ValueFactory<Integer> {
    private static int seed = Integer.MIN_VALUE;

    public IntValueFactory() {
        super(int.class);
    }

    @Override
    public Integer next() {
        return seed++;
    }
}
