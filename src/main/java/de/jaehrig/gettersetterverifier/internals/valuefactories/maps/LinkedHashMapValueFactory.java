package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

import java.util.LinkedHashMap;

/**
 * Represents a HashtableValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class LinkedHashMapValueFactory extends MapValueFactory<LinkedHashMap<String, String>> {
    public LinkedHashMapValueFactory() {
        super(new TypeLiteral<LinkedHashMap<String, String>>() {}, LinkedHashMap::new);
    }
}
