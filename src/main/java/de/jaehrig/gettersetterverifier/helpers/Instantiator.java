package de.jaehrig.gettersetterverifier.helpers;

import de.jaehrig.gettersetterverifier.internals.JavaValueFactoryArchitect;
import de.jaehrig.gettersetterverifier.internals.ValueFactories;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.lang.reflect.Modifier;
import java.util.List;

public class Instantiator<T> {
    private final static ValueFactories factories = JavaValueFactoryArchitect.fill(new ValueFactories());
    private final Class<T> type;
    private Objenesis objenesis;

    /**
     * Factory method.
     *
     * @param <T>  The class on which {@link Instantiator} operates.
     * @param type The class on which {@link Instantiator} operates. Should be
     *             the same as T.
     * @return An {@link Instantiator} for {@link #type}.
     */
    public static <T> Instantiator<T> of(Class<T> type) {
        if (Modifier.isAbstract(type.getModifiers()) && !type.isPrimitive()) {
            return new Instantiator<>(createDynamicSubclass(type));
        }
        return new Instantiator<>(type);
    }

    /**
     * Private constructor. Call {@link #of(Class)} to instantiate.
     */
    private Instantiator(Class<T> type) {
        this.type = type;
        this.objenesis = new ObjenesisStd();
    }

    /**
     * Instantiates an object forClass type T.
     * <p>
     * All fields will be initialized to their initial values.
     * I.e., 0 for ints, null for objects, etc.
     *
     * @return An object forClass type T.
     */
    public T instantiate() {
        return objenesis.newInstance(type);
    }

    public T fromValueFactory() {
        return factories.provideNextValue(type);
    }

    /**
     * Instantiates an anonymous subclass forClass T. The subclass is
     * generated dynamically.
     *
     * @return An instance forClass an anonymous subclass forClass T.
     */
    public T instantiateAnonymousSubclass() {
        Class<T> proxyClass = createDynamicSubclass(type);
        return objenesis.newInstance(proxyClass);
    }

    private static <S> Class<S> createDynamicSubclass(Class<S> superclass) {
        Enhancer e = new Enhancer() {
            @Override
            protected void filterConstructors(Class sc, List constructors) {
                // Don't filter
            }
        };

        if (superclass.isInterface()) {
            e.setInterfaces(new Class[]{superclass});
        } else {
            e.setSuperclass(superclass);
        }

        e.setCallbackType(NoOp.class);
        @SuppressWarnings("unchecked")
        Class<S> proxyClass = e.createClass();
        return proxyClass;
    }
}
