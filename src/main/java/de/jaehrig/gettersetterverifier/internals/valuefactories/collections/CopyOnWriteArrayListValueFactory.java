package de.jaehrig.gettersetterverifier.internals.valuefactories.collections;

import java.util.concurrent.CopyOnWriteArrayList;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a CopyOnWriteArrayListValueFactory
 * Created by nicojs on 8/15/2015.
 */
public class CopyOnWriteArrayListValueFactory extends CollectionValueFactory<CopyOnWriteArrayList<String>> {

    public CopyOnWriteArrayListValueFactory() {
        super(new TypeLiteral<>() {}, CopyOnWriteArrayList::new);
    }
}
