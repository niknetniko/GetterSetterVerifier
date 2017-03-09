package de.jaehrig.gettersetterverifier.internals.valuefactories;

public class EnumValueFactory<T extends Enum> extends ChoiceValueFactory<T> {

    @SuppressWarnings("unchecked")
    public EnumValueFactory(Class targetClass) {
        super(targetClass, (T[]) targetClass.getEnumConstants());
    }
}
