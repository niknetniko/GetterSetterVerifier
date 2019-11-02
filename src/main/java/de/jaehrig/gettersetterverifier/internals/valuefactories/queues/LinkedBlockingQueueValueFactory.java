package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.LinkedBlockingQueue;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a LinkedBlockingQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class LinkedBlockingQueueValueFactory extends CollectionValueFactory<LinkedBlockingQueue<String>> {
    public LinkedBlockingQueueValueFactory() {
        super(new TypeLiteral<>() {}, LinkedBlockingQueue::new);
    }
}
