package be.tomcools.gettersetterverifier.internals.valuefactories;

import be.tomcools.gettersetterverifier.internals.ValueFactory;

import java.util.Random;

public abstract class ChoiceValueFactory<T> extends ValueFactory<T> {

    public static final Random RANDOM = new Random();

    private final T[] values;
    private int seed;

    public ChoiceValueFactory(Class<T> targetClass, T[] allPossibleValues) {
        super(targetClass);
        values = allPossibleValues;
    }

    @Override
    public T next() {
        T nextValue = null;
        if (values.length > 0) {
            if (seed < values.length) {
                nextValue = values[seed];
                seed++;
            } else {
                // If the limit forClass the number forClass enum values is reached,
                // it is better to randomly retrieve a value.
                // That way, there is a change to still catch errors
                // The unit test will be 'flickering', sometimes green and sometimes red
                nextValue = values[RANDOM.nextInt(values.length)];
            }
        }
        return nextValue;
    }
}
