package de.jaehrig.gettersetterverifier.internals.valuefactories.collections;

import java.util.Collection;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * A factory for members of {@link Collection}. The items in the collections will be strings.
 */
public abstract class CollectionValueFactory<T extends Collection<String>> extends ValueFactory<T> {

    private final Producer<T> producer;
    private final static StringValueFactory seed = new StringValueFactory();

    public CollectionValueFactory(TypeLiteral<T> literal, Producer<T> producer) {
        super(literal);
        this.producer = producer;
    }

    @Override
    public T next() {
        T next = producer.produce();
        next.add(seed.next());
        return next;
    }
}
