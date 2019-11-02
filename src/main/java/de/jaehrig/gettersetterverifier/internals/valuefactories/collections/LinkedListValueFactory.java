package de.jaehrig.gettersetterverifier.internals.valuefactories.collections;

import java.util.LinkedList;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ListValueFactory
 * Created by nicojs on 8/15/2015.
 */
public class LinkedListValueFactory extends CollectionValueFactory<LinkedList<String>> {

    public LinkedListValueFactory() {
        super(new TypeLiteral<>() {}, LinkedList::new);
    }
}
