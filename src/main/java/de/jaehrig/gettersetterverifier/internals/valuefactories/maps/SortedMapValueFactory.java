package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.SortedMap;
import java.util.TreeMap;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a SortedMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class SortedMapValueFactory extends MapValueFactory<SortedMap<String, String>> {
    public SortedMapValueFactory() {
        super(new TypeLiteral<SortedMap<String, String>>() {}, TreeMap::new);
    }
}
