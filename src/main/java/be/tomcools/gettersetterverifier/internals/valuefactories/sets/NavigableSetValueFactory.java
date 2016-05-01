package be.tomcools.gettersetterverifier.internals.valuefactories.sets;

import be.tomcools.gettersetterverifier.internals.Producer;
import be.tomcools.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

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
