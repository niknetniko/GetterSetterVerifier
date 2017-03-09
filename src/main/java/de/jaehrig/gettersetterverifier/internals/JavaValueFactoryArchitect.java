package de.jaehrig.gettersetterverifier.internals;

import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.ArrayListValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.CopyOnWriteArrayListValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.LinkedListValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.collections.ListValueFactory;

import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.ConcurrentHashMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.ConcurrentNavigableMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.EnumMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.HashMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.HashtableValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.LinkedHashMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.MapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.NavigableMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.PropertiesValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.SortedMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.TreeMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.maps.WeakHashMapValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.AtomicIntegerValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.BooleanValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.ByteValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.CharValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.ClassValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.DoubleValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.FloatValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.IntValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.LongValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.ShortValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.ArrayBlockingQueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.BlockingDequeValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.BlockingQueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.ConcurrentLinkedDequeueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.ConcurrentLinkedQueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.DelayQueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.DequeValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.LinkedBlockingQueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.PriorityBlockingQueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.QueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.queues.SynchronousQueueValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.BitSetValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.CopyOnWriteArraySetValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.EnumSetValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.HashSetValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.NavigableSetValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.SetValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.SortedSetValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.sets.TreeSetValueFactory;
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
