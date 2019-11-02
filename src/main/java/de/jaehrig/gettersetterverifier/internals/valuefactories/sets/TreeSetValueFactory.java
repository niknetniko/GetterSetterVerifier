package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import java.util.TreeSet;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a TreeSetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class TreeSetValueFactory extends CollectionValueFactory<TreeSet<String>> {
    public TreeSetValueFactory() {
        super(new TypeLiteral<>() {}, TreeSet::new);
    }
}
