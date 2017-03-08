package be.tomcools.gettersetterverifier.wrappers;

import java.lang.reflect.Method;

public class MethodDeclaration {
    private final String name;
    private final Method method;

    public MethodDeclaration(String name, Method method) {
        this.name  = name;
        this.method = method;
    }

    public Class<?> getReturnType() {
        return method.getReturnType();
    }

    public int getParameterCount() {
        return method.getParameterTypes().length;
    }

    public String getName() {
        return name;
    }

    public Method getMethod() {
        return method;
    }
}
