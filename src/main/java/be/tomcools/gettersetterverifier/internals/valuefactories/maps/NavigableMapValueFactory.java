package be.tomcools.gettersetterverifier.internals.valuefactories.maps;

import be.tomcools.gettersetterverifier.internals.Producer;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Represents a NavigableMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class NavigableMapValueFactory extends MapValueFactory<NavigableMap> {

    public NavigableMapValueFactory() {
        super(NavigableMap.class, new Producer<NavigableMap>() {
            @Override
            public NavigableMap produce() {
                return new TreeMap();
            }
        });

    }
}
