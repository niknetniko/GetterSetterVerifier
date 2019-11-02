package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import java.util.HashSet;
import java.util.Set;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a SetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class SetValueFactory extends CollectionValueFactory<Set<String>> {
    public SetValueFactory() {
        super(new TypeLiteral<Set<String>>() {}, HashSet::new);
    }
}
