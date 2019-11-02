package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.concurrent.ConcurrentHashMap;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ConcurrentHashMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class ConcurrentHashMapValueFactory extends MapValueFactory<ConcurrentHashMap<String, String>> {
    public ConcurrentHashMapValueFactory() {
        super(new TypeLiteral<>() {}, ConcurrentHashMap::new);
    }
}
