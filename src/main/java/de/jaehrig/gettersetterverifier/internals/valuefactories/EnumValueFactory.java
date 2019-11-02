package de.jaehrig.gettersetterverifier.internals.valuefactories;

public class EnumValueFactory<T extends Enum<T>> extends ChoiceValueFactory<T> {

    @SuppressWarnings("unchecked")
    public EnumValueFactory(Class<?> targetClass) {
        super((Class<T>) targetClass, (T[]) targetClass.getEnumConstants());
    }
}
