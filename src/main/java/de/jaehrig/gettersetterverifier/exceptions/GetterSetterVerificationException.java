package de.jaehrig.gettersetterverifier.exceptions;

public class GetterSetterVerificationException extends AssertionError {
    public GetterSetterVerificationException(Object detailMessage) {
        super(detailMessage);
    }
}
