package be.tomcools.gettersetterverifier;


public class VerificationResult {
    public final static VerificationResult SUCCESS = new VerificationResult(true, "ok");

    private final boolean success;

    private final String message;

    VerificationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public static VerificationResultBuilder builder() {
        return new VerificationResultBuilder();
    }

    public static class VerificationResultBuilder {
        private boolean success;
        private String message;


        public VerificationResultBuilder success(boolean success) {
            this.success = success;
            return this;
        }

        public VerificationResultBuilder message(String message) {
            this.message = message;
            return this;
        }

        public VerificationResult build() {
            return new VerificationResult(success, message);
        }
    }
}
