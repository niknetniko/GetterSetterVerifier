package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Represents a NavigableSetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class NavigableSetValueFactory extends CollectionValueFactory<NavigableSet> {
    public NavigableSetValueFactory() {
        super(NavigableSet.class, new Producer<NavigableSet>() {
            @Override
            public NavigableSet produce() {
                return new TreeSet();
            }
        });
    }
}
