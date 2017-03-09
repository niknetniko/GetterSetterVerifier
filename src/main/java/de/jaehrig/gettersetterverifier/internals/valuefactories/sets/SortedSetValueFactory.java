package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Represents a SortedSetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class SortedSetValueFactory extends CollectionValueFactory<SortedSet> {
    public SortedSetValueFactory() {
        super(SortedSet.class, new Producer<SortedSet>() {
            @Override
            public SortedSet produce() {
                return new TreeSet();
            }
        });
    }
}
