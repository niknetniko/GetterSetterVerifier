package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Represents a ArrayBlockingQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class ArrayBlockingQueueValueFactory extends CollectionValueFactory<ArrayBlockingQueue> {
    public ArrayBlockingQueueValueFactory() {
        super(ArrayBlockingQueue.class, new Producer<ArrayBlockingQueue>() {
            @Override
            public ArrayBlockingQueue produce() {
                return new ArrayBlockingQueue(1);
            }
        });
    }
}
