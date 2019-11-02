package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a BlockingDequeValueFactory
 * Created by nicojs on 8/19/2015.
 */
public class BlockingDequeValueFactory extends CollectionValueFactory<BlockingDeque<String>> {
    public BlockingDequeValueFactory() {
        super(new TypeLiteral<BlockingDeque<String>>() {}, () -> new LinkedBlockingDeque<>(1));
    }
}
