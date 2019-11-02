package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.WeakHashMap;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a SortedMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class WeakHashMapValueFactory extends MapValueFactory<WeakHashMap<String, String>> {

    public WeakHashMapValueFactory() {
        super(new TypeLiteral<>() {}, WeakHashMap::new);
    }
}
