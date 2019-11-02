package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.HashMap;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a HashMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class HashMapValueFactory extends MapValueFactory<HashMap<String, String>> {
    public HashMapValueFactory() {
        super(new TypeLiteral<HashMap<String, String>>() {}, HashMap::new);
    }
}
