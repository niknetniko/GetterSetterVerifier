package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Represents a QueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class QueueValueFactory extends CollectionValueFactory<Queue> {
    public QueueValueFactory() {
        super(Queue.class, new Producer<Queue>() {
            @Override
            public Queue produce() {
                return new ArrayBlockingQueue(1);
            }
        });
    }
}
