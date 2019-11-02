package de.jaehrig.gettersetterverifier.internals.valuefactories.collections;

import java.util.ArrayList;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ListValueFactory
 * Created by nicojs on 8/15/2015.
 */
public class ArrayListValueFactory extends CollectionValueFactory<ArrayList<String>> {
    public ArrayListValueFactory() {
        super(new TypeLiteral<>() {}, ArrayList::new);
    }
}
