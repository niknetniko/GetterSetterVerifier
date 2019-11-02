package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a BlockingQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class BlockingQueueValueFactory extends CollectionValueFactory<BlockingQueue<String>> {
    public BlockingQueueValueFactory() {
        super(new TypeLiteral<>() {}, () -> new ArrayBlockingQueue<>(1));
    }
}
