package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.Producer;

import java.util.TreeMap;

/**
 * Represents a HashtableValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class TreeMapValueFactory extends MapValueFactory<TreeMap> {

    public TreeMapValueFactory() {
        super(TreeMap.class, new Producer<TreeMap>() {
            @Override
            public TreeMap produce() {
                return new TreeMap();
            }
        });
    }
}
