package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;

import java.util.EnumMap;

/**
 * Represents a SortedMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class EnumMapValueFactory extends ValueFactory<EnumMap> {

    private final static StringValueFactory SEED = new StringValueFactory();
    private static Number CURRENT_NUMBER = Number.ONE;

    public EnumMapValueFactory() {
        super(EnumMap.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public EnumMap next() {
        if (CURRENT_NUMBER == Number.ONE) {
            CURRENT_NUMBER = Number.TWO;
        } else {
            CURRENT_NUMBER = Number.ONE;
        }
        EnumMap enumMap = new EnumMap(Number.class);
        enumMap.put(CURRENT_NUMBER, SEED.next());
        return enumMap;
    }

    public enum Number {
        ONE,
        TWO
    }
}
