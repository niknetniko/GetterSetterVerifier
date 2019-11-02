package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a QueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class QueueValueFactory extends CollectionValueFactory<Queue<String>> {
    public QueueValueFactory() {
        super(new TypeLiteral<>() {}, () -> new ArrayBlockingQueue(1));
    }
}
