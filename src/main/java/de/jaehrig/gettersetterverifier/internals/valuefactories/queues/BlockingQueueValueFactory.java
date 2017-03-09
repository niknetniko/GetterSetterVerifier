package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Represents a BlockingQueueValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class BlockingQueueValueFactory extends CollectionValueFactory<BlockingQueue> {
    public BlockingQueueValueFactory() {
        super(BlockingQueue.class, new Producer<BlockingQueue>() {
            @Override
            public BlockingQueue produce() {
                return new ArrayBlockingQueue(1);
            }
        });
    }
}
