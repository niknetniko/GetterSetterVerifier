package de.jaehrig.gettersetterverifier.checks.examples;

@SuppressWarnings("unused")
public class CompletelyValidClass {
    private String something;
    private String somethingElse;

    public String getSomething() {
        return something;
    }

    public String getSomethingElse() {
        return somethingElse;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public void setSomethingElse(String somethingElse) {
        this.somethingElse = somethingElse;
    }

    public static class InnerClass {
        private String something;
        private String somethingElse;

        public String getSomething() {
            return something;
        }

        public String getSomethingElse() {
            return somethingElse;
        }

        public void setSomething(String something) {
            this.something = something;
        }

        public void setSomethingElse(String somethingElse) {
            this.somethingElse = somethingElse;
        }
    }
}
