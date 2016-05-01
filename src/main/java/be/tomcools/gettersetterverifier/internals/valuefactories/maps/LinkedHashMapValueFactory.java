package be.tomcools.gettersetterverifier.internals.valuefactories.maps;

import be.tomcools.gettersetterverifier.internals.Producer;

import java.util.LinkedHashMap;

/**
 * Represents a HashtableValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class LinkedHashMapValueFactory extends MapValueFactory<LinkedHashMap> {

    public LinkedHashMapValueFactory() {
        super(LinkedHashMap.class, new Producer<LinkedHashMap>() {
            @Override
            public LinkedHashMap produce() {
                return new LinkedHashMap();
            }
        });
    }
}
