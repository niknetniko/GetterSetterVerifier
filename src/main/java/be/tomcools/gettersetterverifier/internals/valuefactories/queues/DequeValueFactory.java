package be.tomcools.gettersetterverifier.internals.valuefactories.queues;

import be.tomcools.gettersetterverifier.internals.Producer;
import be.tomcools.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Represents a Deque
 * Created by nicojs on 8/19/2015.
 */
public class DequeValueFactory extends CollectionValueFactory<Deque> {
    public DequeValueFactory() {
        super(Deque.class, new Producer<Deque>() {
            @Override
            public Deque produce() {
                return new ArrayDeque(1);
            }
        });
    }
}
