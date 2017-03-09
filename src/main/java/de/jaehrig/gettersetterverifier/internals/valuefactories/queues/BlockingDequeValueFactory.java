package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Represents a BlockingDequeValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class BlockingDequeValueFactory extends CollectionValueFactory<BlockingDeque> {
    public BlockingDequeValueFactory() {
        super(BlockingDeque.class, new Producer<BlockingDeque>() {
            @Override
            public BlockingDeque produce() {
                return new LinkedBlockingDeque(1);
            }
        });
    }
}
