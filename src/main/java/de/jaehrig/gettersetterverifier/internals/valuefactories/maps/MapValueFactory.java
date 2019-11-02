package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

import java.util.Map;

public class MapValueFactory<T extends Map<String, String>> extends ValueFactory<T> {

    private final static StringValueFactory seed = new StringValueFactory();
    private final Producer<T> producer;

    public MapValueFactory(TypeLiteral<T> targetClass, Producer<T> producer) {
        super(targetClass);
        this.producer = producer;
    }

    @Override
    public T next() {
        T next = producer.produce();
        next.put(seed.next(), seed.next());
        return next;
    }
}
