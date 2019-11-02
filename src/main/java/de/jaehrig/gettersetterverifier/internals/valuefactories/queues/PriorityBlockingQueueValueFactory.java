package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.PriorityBlockingQueue;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a PriorityBlockingQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class PriorityBlockingQueueValueFactory extends CollectionValueFactory<PriorityBlockingQueue<String>> {
    public PriorityBlockingQueueValueFactory() {
        super(new TypeLiteral<PriorityBlockingQueue<String>>() {}, PriorityBlockingQueue::new);
    }
}
