package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Represents a SortedSetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class SortedSetValueFactory extends CollectionValueFactory<SortedSet<String>> {
    public SortedSetValueFactory() {
        super(new TypeLiteral<>() {}, TreeSet::new);
    }
}
