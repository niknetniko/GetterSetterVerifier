package be.tomcools.gettersetterverifier.internals.valuefactories.maps;

import be.tomcools.gettersetterverifier.internals.Producer;

import java.util.HashMap;

/**
 * Represents a HashMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class HashMapValueFactory extends MapValueFactory<HashMap> {
    public HashMapValueFactory() {
        super(HashMap.class, new Producer<HashMap>() {
            @Override
            public HashMap produce() {
                return new HashMap();
            }
        });
    }
}
