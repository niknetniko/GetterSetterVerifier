package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.TreeMap;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a HashtableValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class TreeMapValueFactory extends MapValueFactory<TreeMap<String, String>> {
    public TreeMapValueFactory() {
        super(new TypeLiteral<TreeMap<String, String>>() {}, TreeMap::new);
    }
}
