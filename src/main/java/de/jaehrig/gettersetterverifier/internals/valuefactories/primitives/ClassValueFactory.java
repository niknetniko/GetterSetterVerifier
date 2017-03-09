package de.jaehrig.gettersetterverifier.internals.valuefactories.primitives;

import de.jaehrig.gettersetterverifier.internals.valuefactories.ChoiceValueFactory;

/**
 * Represents a ClassValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class ClassValueFactory extends ChoiceValueFactory<Class> {

    public ClassValueFactory() {
        super(Class.class, new Class[]{
                ClassValueFactory.class,
                String.class,
                Integer.class,
                Double.class,
                Float.class,
                Long.class,
                Boolean.class,
                Short.class,
                int.class,
                double.class,
                float.class,
                long.class,
                boolean.class,
                short.class
        });
    }
}
