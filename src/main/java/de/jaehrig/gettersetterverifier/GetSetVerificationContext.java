package de.jaehrig.gettersetterverifier;

import de.jaehrig.gettersetterverifier.helpers.Instantiator;
import de.jaehrig.gettersetterverifier.wrappers.FieldDeclaration;
import de.jaehrig.gettersetterverifier.wrappers.Fields;
import de.jaehrig.gettersetterverifier.wrappers.Methods;

public class GetSetVerificationContext<T> {
    private final Class<T> classToTest;
    private final Fields fields;
    private final Methods methods;

    GetSetVerificationContext(Class<T> classToTest, Fields fields, Methods methods) {
        this.classToTest = classToTest;
        this.fields = fields;
        this.methods = methods;
    }

    public static GetSetVerificationContextBuilder builder() {
        return new GetSetVerificationContextBuilder();
    }

    public T newEmptyInstance() {
        return Instantiator.of(classToTest).instantiate();
    }

    public T newConfiguredInstance() {
        T emptyInstance = newEmptyInstance();
        return fillFields(emptyInstance);
    }

    public Class<T> getClassToTest() {
        return classToTest;
    }

    public Fields getFields() {
        return fields;
    }

    public Methods getMethods() {
        return methods;
    }

    private T fillFields(T instance) {
        for (FieldDeclaration field : fields) {
            fillField(instance, field);
        }
        return instance;
    }

    private void fillField(T instance, FieldDeclaration field) {
        Class<?> fieldType = field.getType();
        Object fieldValue = Instantiator.of(fieldType).fromValueFactory();
        field.set(instance, fieldValue);
    }

    public static class GetSetVerificationContextBuilder<T> {
        private Class<T> classToTest;
        private Fields fields;
        private Methods methods;

        GetSetVerificationContextBuilder() {
            // empty
        }

        public GetSetVerificationContextBuilder classToTest(Class<T> classToTest) {
            this.classToTest = classToTest;
            return this;
        }

        public GetSetVerificationContextBuilder fields(Fields fields) {
            this.fields = fields;
            return this;
        }


        public GetSetVerificationContextBuilder methods(Methods methods) {
            this.methods = methods;
            return this;

        }

        public GetSetVerificationContext build() {
            return new GetSetVerificationContext(classToTest, fields, methods);
        }
    }


}
