package de.jaehrig.gettersetterverifier.internals.valuefactories.sets;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CollectionValueFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a SetValueFactory
 * Created by nicojs on 8/17/2015.
 */
public class SetValueFactory extends CollectionValueFactory<Set> {
    public SetValueFactory() {
        super(Set.class, new Producer<Set>() {
            @Override
            public Set produce() {
                return new HashSet();
            }
        });
    }
}
