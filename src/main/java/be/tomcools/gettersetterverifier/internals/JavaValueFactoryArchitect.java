package be.tomcools.gettersetterverifier.internals;

import be.tomcools.gettersetterverifier.internals.valuefactories.collections.ArrayListValueFactory;
import be.tomcools.gettersetterverifier.internals.valuefactories.collections.CopyOnWriteArrayListValueFactory;
import be.tomcools.gettersetterverifier.internals.valuefactories.collections.LinkedListValueFactory;
import be.tomcools.gettersetterverifier.internals.valuefactories.collections.ListValueFactory;
import be.tomcools.gettersetterverifier.internals.valuefactories.maps.*;
import be.tomcools.gettersetterverifier.internals.valuefactories.primitives.*;
import be.tomcools.gettersetterverifier.internals.valuefactories.queues.*;
import be.tomcools.gettersetterverifier.internals.valuefactories.sets.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a JavaValueFactoryArchitect
 * Created by nicojs on 8/13/2015.
 */
@SuppressWarnings("unchecked")
public class JavaValueFactoryArchitect {
    private JavaValueFactoryArchitect() {
    }

    public static ValueFactories fill(ValueFactories valueFactories) {
        fillPrimitiveClasses(valueFactories);
        fillCollectionClasses(valueFactories);
        fillMapClasses(valueFactories);
        fillSetClasses(valueFactories);
        fillQueueClasses(valueFactories);
        return valueFactories;
    }

    private static void fillMapClasses(ValueFactories valueFactories) {
        valueFactories.putIfNotExists(
                new ConcurrentHashMapValueFactory(),
                new ConcurrentNavigableMapValueFactory(),
                new EnumMapValueFactory(),
                new HashMapValueFactory(),
                new HashtableValueFactory(),
                new LinkedHashMapValueFactory(),
                new NavigableMapValueFactory(),
                new PropertiesValueFactory(),
                new SortedMapValueFactory(),
                new TreeMapValueFactory(),
                new WeakHashMapValueFactory(),
                new MapValueFactory(Map.class, new Producer() {
                    @Override
                    public Object produce() {
                        return new HashMap();
                    }
                })
        );
    }

    private static void fillCollectionClasses(ValueFactories valueFactories) {
        valueFactories.putIfNotExists(
                new ArrayListValueFactory(),
                new ListValueFactory(),
                new LinkedListValueFactory(),
                new CopyOnWriteArrayListValueFactory());
    }

    private static void fillPrimitiveClasses(ValueFactories valueFactories) {
        valueFactories.putIfNotExists(
                new AtomicIntegerValueFactory(),
                new BooleanValueFactory(),
                new ByteValueFactory(),
                new CharValueFactory(),
                new ClassValueFactory(),
                new DoubleValueFactory(),
                new FloatValueFactory(),
                new IntValueFactory(),
                new LongValueFactory(),
                new ShortValueFactory(),
                new StringValueFactory());
    }

    private static void fillSetClasses(ValueFactories valueFactories) {
        valueFactories.putIfNotExists(
                new BitSetValueFactory(),
                new CopyOnWriteArraySetValueFactory(),
                new EnumSetValueFactory(),
                new HashSetValueFactory(),
                new NavigableSetValueFactory(),
                new SetValueFactory(),
                new SortedSetValueFactory(),
                new TreeSetValueFactory()
        );
    }

    private static void fillQueueClasses(ValueFactories valueFactories) {
        valueFactories.putIfNotExists(
                new ArrayBlockingQueueValueFactory(),
                new BlockingDequeValueFactory(),
                new BlockingQueueValueFactory(),
                new ConcurrentLinkedQueueValueFactory(),
                new ConcurrentLinkedDequeueValueFactory(),
                new DelayQueueValueFactory(),
                new DequeValueFactory(),
                new LinkedBlockingQueueValueFactory(),
                new PriorityBlockingQueueValueFactory(),
                new QueueValueFactory(),
                new SynchronousQueueValueFactory()
        );
    }
}
