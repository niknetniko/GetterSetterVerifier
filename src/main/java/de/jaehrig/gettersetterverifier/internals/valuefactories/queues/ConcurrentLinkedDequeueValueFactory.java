package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.ConcurrentLinkedDeque;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ConcurrentLinkedQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class ConcurrentLinkedDequeueValueFactory extends CollectionValueFactory<ConcurrentLinkedDeque<String>> {
    public ConcurrentLinkedDequeueValueFactory() {
        super(new TypeLiteral<ConcurrentLinkedDeque<String>>() {}, ConcurrentLinkedDeque::new);
    }
}
