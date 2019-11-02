package de.jaehrig.gettersetterverifier.relfections;

import de.jaehrig.gettersetterverifier.GetterSetterVerifier;
import org.junit.jupiter.api.Test;

public class FieldCollectionTest {

    @Test
    public void shouldHandleFinalStaticFields() {
        GetterSetterVerifier.forClass(StaticField.class).verify();
    }

    @SuppressWarnings("unused")
    static class StaticField {

        public static final String TEST = "Hallo";

        private String number;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
