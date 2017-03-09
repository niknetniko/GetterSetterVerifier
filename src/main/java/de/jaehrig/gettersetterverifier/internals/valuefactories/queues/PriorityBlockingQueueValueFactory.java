package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Represents a PriorityBlockingQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class PriorityBlockingQueueValueFactory extends CollectionValueFactory<PriorityBlockingQueue> {
    public PriorityBlockingQueueValueFactory() {
        super(PriorityBlockingQueue.class, new Producer<PriorityBlockingQueue>() {
            @Override
            public PriorityBlockingQueue produce() {
                return new PriorityBlockingQueue(1);
            }
        });
    }
}
