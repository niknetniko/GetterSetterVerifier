package de.jaehrig.gettersetterverifier.checks.examples;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class OnlyValidSetter {
    private String something;

    public void setSomething(String something) {
        this.something = something;
    }
}
