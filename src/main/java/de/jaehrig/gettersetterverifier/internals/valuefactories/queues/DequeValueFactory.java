package de.jaehrig.gettersetterverifier.internals.valuefactories.queues;

import java.util.ArrayDeque;
import java.util.Deque;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a Deque
 * Created by nicojs on 8/19/2015.
 */
public class DequeValueFactory extends CollectionValueFactory<Deque<String>> {
    public DequeValueFactory() {
        super(new TypeLiteral<>() {}, ArrayDeque::new);
    }
}
