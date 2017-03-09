package de.jaehrig.gettersetterverifier.internals.valuefactories.collections;

import de.jaehrig.gettersetterverifier.internals.Producer;

import java.util.ArrayList;

/**
 * Represents a ListValueFactory
 * Created by nicojs on 8/15/2015.
 */
public class ArrayListValueFactory extends CollectionValueFactory<ArrayList> {

    public ArrayListValueFactory() {
        super(ArrayList.class, new Producer<ArrayList>() {
            @Override
            public ArrayList produce() {
                return new ArrayList(1);
            }
        });
    }
}
