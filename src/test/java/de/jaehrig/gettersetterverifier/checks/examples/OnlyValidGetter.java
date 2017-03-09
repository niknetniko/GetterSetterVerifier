package de.jaehrig.gettersetterverifier.checks.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnlyValidGetter {
    private List<String> something = new ArrayList<>();

    public List<String> getSomething() {
        return Collections.unmodifiableList(something);
    }
}
