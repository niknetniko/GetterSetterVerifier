package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

import java.util.Hashtable;

/**
 * Represents a HashtableValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class HashtableValueFactory extends MapValueFactory<Hashtable<String, String>> {
    public HashtableValueFactory() {
        super(new TypeLiteral<>() {}, Hashtable::new);
    }
}
