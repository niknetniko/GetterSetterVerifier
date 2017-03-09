package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.Producer;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Represents a SortedMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class SortedMapValueFactory extends MapValueFactory<SortedMap> {

    public SortedMapValueFactory() {
        super(SortedMap.class, new Producer<SortedMap>() {
            @Override
            public SortedMap produce() {
                return new TreeMap();
            }
        });
    }
}
