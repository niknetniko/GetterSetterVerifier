package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

import java.util.concurrent.SynchronousQueue;

/**
 * Represents a SynchronousQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class SynchronousQueueValueFactory extends ValueFactory<SynchronousQueue<String>> {
    public SynchronousQueueValueFactory() {
        super(new TypeLiteral<>() {});
    }

    @Override
    public SynchronousQueue<String> next() {
        return new SynchronousQueue<>(); // Always unique
    }
}
