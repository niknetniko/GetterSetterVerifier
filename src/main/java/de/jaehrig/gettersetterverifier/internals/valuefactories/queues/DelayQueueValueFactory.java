package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.DelayQueue;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a DelayQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class DelayQueueValueFactory extends ValueFactory<DelayQueue<?>> {
    public DelayQueueValueFactory() {
        super(new TypeLiteral<>() {});
    }

    @Override
    public DelayQueue<?> next() {
        return new DelayQueue<>(); // New DelayQueue is always unique
    }
}
