package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.NavigableMap;
import java.util.TreeMap;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a NavigableMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class NavigableMapValueFactory extends MapValueFactory<NavigableMap<String, String>> {
    public NavigableMapValueFactory() {
        super(new TypeLiteral<NavigableMap<String, String>>() {}, TreeMap::new);

    }
}
