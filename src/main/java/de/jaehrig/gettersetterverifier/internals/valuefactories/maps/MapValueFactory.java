package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.Producer;
import de.jaehrig.gettersetterverifier.internals.ValueFactory;
import de.jaehrig.gettersetterverifier.internals.valuefactories.primitives.StringValueFactory;

import java.util.Map;

public class MapValueFactory<T extends Map> extends ValueFactory<T> {

    private final static StringValueFactory seed = new StringValueFactory();
    private final Producer<T> producer;

    public MapValueFactory(Class<T> targetClass, Producer<T> producer) {
        super(targetClass);
        this.producer = producer;
    }

    /*
    *   addMap(Map.class, new HashMap(), new HashMap());
        addMap(SortedMap.class, new TreeMap(), new TreeMap());
        addMap(NavigableMap.class, new TreeMap(), new TreeMap());
        addMap(ConcurrentNavigableMap.class, new ConcurrentSkipListMap(), new ConcurrentSkipListMap());
        prefabValues.put(EnumMap.class, Dummy.RED.map(), Dummy.BLACK.map());
        addMap(ConcurrentHashMap.class, new ConcurrentHashMap(), new ConcurrentHashMap());
        addMap(HashMap.class, new HashMap(), new HashMap());
        addMap(Hashtable.class, new Hashtable(), new Hashtable());
        addMap(LinkedHashMap.class, new LinkedHashMap(), new LinkedHashMap());
        addMap(Properties.class, new Properties(), new Properties());
        addMap(TreeMap.class, new TreeMap(), new TreeMap());
        addMap(WeakHashMap.class, new WeakHashMap(), new WeakHashMap());
    * */

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        T next = producer.produce();
        next.put(seed.next(), seed.next());
        return next;
    }
}
