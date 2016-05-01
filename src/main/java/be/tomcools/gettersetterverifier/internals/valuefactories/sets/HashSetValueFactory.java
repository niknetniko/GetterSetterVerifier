package be.tomcools.gettersetterverifier.internals.valuefactories.sets;

import be.tomcools.gettersetterverifier.internals.Producer;
import be.tomcools.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.HashSet;

/**
 * Represents a HashsetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class HashSetValueFactory extends CollectionValueFactory<HashSet> {
    public HashSetValueFactory() {
        super(HashSet.class, new Producer<HashSet>() {
            @Override
            public HashSet produce() {
                return new HashSet();
            }
        });
    }
}
