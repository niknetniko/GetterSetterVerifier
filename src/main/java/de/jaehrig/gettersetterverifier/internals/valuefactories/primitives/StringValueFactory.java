package de.jaehrig.gettersetterverifier.internals.valuefactories.primitives;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;

/**
 * Represents a StringValueFactory
 * Created by nicojs on 8/13/2015.
 */
public class StringValueFactory extends ValueFactory<String> {
    private int seed = 0;

    public StringValueFactory() {
        super(String.class);
    }


    @Override
    public String next() {
        return String.format("String$%s", Integer.toString(seed++));
    }
}
