package de.jaehrig.gettersetterverifier.internals.valuefactories.collections;

import java.util.ArrayList;
import java.util.List;

import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a ListValueFactory
 * Created by nicojs on 8/15/2015.
 */
public class ListValueFactory extends CollectionValueFactory<List<String>> {

    public ListValueFactory() {
        super(new TypeLiteral<>() {}, ArrayList::new);
    }
}
