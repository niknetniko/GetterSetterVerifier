package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.ArrayBlockingQueue;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Created by nicojs on 8/19/2015.
 */
public class ArrayBlockingQueueValueFactory extends CollectionValueFactory<ArrayBlockingQueue<String>> {
    public ArrayBlockingQueueValueFactory() {
        super(new TypeLiteral<ArrayBlockingQueue<String>>() {}, () -> new ArrayBlockingQueue<>(1));
    }
}
