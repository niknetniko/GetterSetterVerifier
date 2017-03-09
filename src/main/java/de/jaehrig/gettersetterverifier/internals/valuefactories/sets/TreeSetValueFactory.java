package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.TreeSet;

/**
 * Represents a TreeSetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class TreeSetValueFactory extends CollectionValueFactory<TreeSet> {
    public TreeSetValueFactory() {
        super(TreeSet.class, new Producer<TreeSet>() {
            @Override
            public TreeSet produce() {
                return new TreeSet();
            }
        });
    }
}
