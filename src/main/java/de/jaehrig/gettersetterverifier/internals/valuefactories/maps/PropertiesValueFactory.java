package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.Properties;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a HashtableValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class PropertiesValueFactory extends ValueFactory<Properties> {

    private final static StringValueFactory seed = new StringValueFactory();

    public PropertiesValueFactory() {
        super(new TypeLiteral<>() {});
    }

    @Override
    public Properties next() {
        var next = new Properties();
        next.put(seed.next(), seed.next());
        return next;
    }
}
