package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import java.util.HashSet;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a HashsetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class HashSetValueFactory extends CollectionValueFactory<HashSet<String>> {
    public HashSetValueFactory() {
        super(new TypeLiteral<>() {}, HashSet::new);
    }
}
