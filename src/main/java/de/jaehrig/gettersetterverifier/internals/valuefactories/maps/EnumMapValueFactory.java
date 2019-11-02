package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import java.util.EnumMap;

import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;
import de.jaehrig.gettersetterverifier.util.TypeLiteral;

/**
 * Represents a SortedMapValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class EnumMapValueFactory extends ValueFactory<EnumMap<EnumMapValueFactory.Number, String>> {

    private final static StringValueFactory SEED = new StringValueFactory();
    private static Number CURRENT_NUMBER = Number.ONE;

    public EnumMapValueFactory() {
        super(new TypeLiteral<>() {});
    }

    @Override
    public EnumMap<EnumMapValueFactory.Number, String> next() {
        if (CURRENT_NUMBER == Number.ONE) {
            CURRENT_NUMBER = Number.TWO;
        } else {
            CURRENT_NUMBER = Number.ONE;
        }
        var enumMap = new EnumMap<EnumMapValueFactory.Number, String>(Number.class);
        enumMap.put(CURRENT_NUMBER, SEED.next());
        return enumMap;
    }

    public enum Number {
        ONE,
        TWO
    }
}
