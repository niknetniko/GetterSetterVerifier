package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ConcurrentNavigableMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class ConcurrentNavigableMapValueFactory extends MapValueFactory<ConcurrentNavigableMap<String, String>> {
    public ConcurrentNavigableMapValueFactory() {
        super(new TypeLiteral<>() {}, ConcurrentSkipListMap::new);
    }
}
