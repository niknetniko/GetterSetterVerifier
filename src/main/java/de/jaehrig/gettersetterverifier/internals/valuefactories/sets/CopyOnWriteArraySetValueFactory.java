package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import java.util.concurrent.CopyOnWriteArraySet;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a CopyOnWriteArraySetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class CopyOnWriteArraySetValueFactory extends CollectionValueFactory<CopyOnWriteArraySet<String>> {
    public CopyOnWriteArraySetValueFactory() {
        super(new TypeLiteral<CopyOnWriteArraySet<String>>() {}, CopyOnWriteArraySet::new);
    }
}
