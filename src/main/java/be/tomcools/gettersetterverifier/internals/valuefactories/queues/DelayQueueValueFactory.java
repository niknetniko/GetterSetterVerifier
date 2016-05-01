package be.tomcools.gettersetterverifier.internals.valuefactories.queues;

import be.tomcools.gettersetterverifier.internals.ValueFactory;

import java.util.concurrent.DelayQueue;

/**
 * Represents a DelayQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class DelayQueueValueFactory extends ValueFactory<DelayQueue> {
    public DelayQueueValueFactory() {
        super(DelayQueue.class);
    }

    @Override
    public DelayQueue next() {
        return new DelayQueue(); // New DelayQueue is always unique
    }
}
