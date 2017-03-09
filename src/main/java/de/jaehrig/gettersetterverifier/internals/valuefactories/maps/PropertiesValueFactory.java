package de.jaehrig.gettersetterverifier.internals.valuefactories.maps;

import de.jaehrig.gettersetterverifier.internals.Producer;

import java.util.Properties;

/**
 * Represents a HashtableValueFactory
 * Created by nicojs on 8/16/2015.
 */
public class PropertiesValueFactory extends MapValueFactory<Properties> {

    public PropertiesValueFactory() {
        super(Properties.class, new Producer<Properties>() {
            @Override
            public Properties produce() {
                return new Properties();
            }
        });
    }
}
