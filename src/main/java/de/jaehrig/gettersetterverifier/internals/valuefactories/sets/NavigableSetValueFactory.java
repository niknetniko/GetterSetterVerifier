package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Represents a NavigableSetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class NavigableSetValueFactory extends CollectionValueFactory<NavigableSet<String>> {
    public NavigableSetValueFactory() {
        super(new TypeLiteral<>() {}, TreeSet::new);
    }
}
