package de.jaehrig.gettersetterverifier.internals.valuefactories.collections;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;

import java.util.Collection;

/**
 * Represents a CollectionValueFactory
 * Created by nicojs on 8/15/2015.
 */
public abstract class CollectionValueFactory<T extends Collection> extends ValueFactory<T> {

    private final Producer<T> producer;
    private final static StringValueFactory seed = new StringValueFactory();

    public CollectionValueFactory(Class<T> targetClass, Producer<T> producer) {
        super(targetClass);
        this.producer = producer;
    }


    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        T next = producer.produce();
        next.add(seed.next());
        return next;
    }
}
