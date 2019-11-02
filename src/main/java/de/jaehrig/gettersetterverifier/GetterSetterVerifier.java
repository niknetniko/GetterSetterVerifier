package de.jaehrig.gettersetterverifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.jaehrig.gettersetterverifier.checks.Validations;
import de.jaehrig.gettersetterverifier.exceptions.GetterSetterVerificationException;

public class GetterSetterVerifier<T> {
    private VerificationContextBuilder<T> verificationContextBuilder;
    private List<Validations> verificationToRun;

    GetterSetterVerifier(Class<T> classToTest) {
        this.verificationToRun = determineDefaultValidations();
        this.verificationContextBuilder = VerificationContextBuilder.forClass(classToTest);
    }

    private List<Validations> determineDefaultValidations() {
        List<Validations> verificationToRun = new ArrayList<>();
        Collections.addAll(verificationToRun, Validations.values());
        return verificationToRun;
    }

    public static <T> GetterSetterVerifier<T> forClass(Class<T> classToTest) {
        return new GetterSetterVerifier<>(classToTest);
    }

    public void verify() {
        GetSetVerificationContext<T> verificationContext = verificationContextBuilder.build();
        runValidations(verificationContext);
    }

    private void runValidations(GetSetVerificationContext<T> context) {
        for (Validations validation : this.verificationToRun) {
            VerificationResult result = validation.getGetterSettercheck().execute(context);
            if (!result.isSuccess()) {
                throw new GetterSetterVerificationException(String.format("Validation %s failed!: %s", validation, result.getMessage()));
            }
        }
    }

    public GetterSetterVerifier<T> excludeField(String fieldName) {
        verificationContextBuilder.excludeField(fieldName);
        return this;
    }

    public GetterSetterVerifier<T> excludeChecks(Validations... validation) {
        for (Validations excluded : validation) {
            this.verificationToRun.remove(excluded);
        }
        return this;
    }
}
