package be.tomcools.gettersetterverifier.internals.valuefactories.maps;

import be.tomcools.gettersetterverifier.internals.Producer;

import java.util.WeakHashMap;

/**
 * Represents a SortedMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class WeakHashMapValueFactory extends MapValueFactory<WeakHashMap> {

    public WeakHashMapValueFactory() {
        super(WeakHashMap.class, new Producer<WeakHashMap>() {
            @Override
            public WeakHashMap produce() {
                return new WeakHashMap();
            }
        });
    }
}
