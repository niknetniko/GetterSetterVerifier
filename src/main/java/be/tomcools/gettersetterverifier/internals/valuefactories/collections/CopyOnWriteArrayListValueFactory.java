package be.tomcools.gettersetterverifier.internals.valuefactories.collections;

import be.tomcools.gettersetterverifier.internals.Producer;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Represents a CopyOnWriteArrayListValueFactory
 * Created by nicojs on 8/15/2015.
 */
public class CopyOnWriteArrayListValueFactory extends CollectionValueFactory<CopyOnWriteArrayList> {

    public CopyOnWriteArrayListValueFactory() {
        super(CopyOnWriteArrayList.class, new Producer<CopyOnWriteArrayList>() {
            @Override
            public CopyOnWriteArrayList produce() {
                return new CopyOnWriteArrayList();
            }
        });
    }

}
