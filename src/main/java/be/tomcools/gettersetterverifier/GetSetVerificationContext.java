package be.tomcools.gettersetterverifier;

import be.tomcools.gettersetterverifier.helpers.Instantiator;
import be.tomcools.gettersetterverifier.wrappers.FieldDeclaration;
import be.tomcools.gettersetterverifier.wrappers.Fields;
import be.tomcools.gettersetterverifier.wrappers.Methods;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetSetVerificationContext<T> {
    private Class<T> classToTest;
    private Fields fields;
    private Methods methods;

    public T newEmptyInstance() {
        return Instantiator.of(classToTest).instantiate();
    }

    public T newConfiguredInstance() {
        T emptyInstance = newEmptyInstance();
        return fillFields(emptyInstance);
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
}
