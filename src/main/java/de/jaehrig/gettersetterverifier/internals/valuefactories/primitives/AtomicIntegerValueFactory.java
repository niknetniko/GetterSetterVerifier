package de.jaehrig.gettersetterverifier.internals.valuefactories.primitives;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a AtomicIntegerValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class AtomicIntegerValueFactory extends ValueFactory<AtomicInteger> {

    private int seed = Integer.MIN_VALUE;

    public AtomicIntegerValueFactory() {
        super(AtomicInteger.class);
    }

    @Override
    public AtomicInteger next() {
        return new AtomicInteger(seed++);
    }
}
