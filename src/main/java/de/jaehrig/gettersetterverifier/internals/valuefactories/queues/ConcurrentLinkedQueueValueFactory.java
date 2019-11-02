package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ConcurrentLinkedQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class ConcurrentLinkedQueueValueFactory extends CollectionValueFactory<ConcurrentLinkedQueue<String>> {
    public ConcurrentLinkedQueueValueFactory() {
        super(new TypeLiteral<>() {}, ConcurrentLinkedQueue::new);
    }
}
