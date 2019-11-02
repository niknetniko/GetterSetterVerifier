package de.jaehrig.gettersetterverifier.checks;

import de.jaehrig.gettersetterverifier.GetterSetterCheck;

public enum Validations {
    GETTER_SHOULD_REFERENCE_FIELD(new GetMethodShouldReferenceAField()),
    SETTER_SHOULD_REFERENCE_FIELD(new SetMethodShouldReferenceField()),
    GETTER_SHOULD_BE_PUBLIC(new GetterShouldBePublic()),
    SETTER_SHOULD_BE_PUBLIC(new SetterShouldBePublic()),
    GETTER_SHOULD_NOT_HAVE_A_PARAMETER(new GetterShouldNotHaveParameter()),
    SETTER_SHOULD_NOT_HAVE_EXACTLY_ONE_PARAMETER(new SetterShouldHaveExactlyOneParameter()),
    SETTER_PARAMETER_SHOULD_BE_OF_SAME_TYPE_AS_FIELD(new ParameterOfSetterTypeCheck()),
    GETTER_RETURN_TYPE_SHOULD_BE_OF_SAME_TYPE_AS_FIELD(new ReturnTypeOfGetterTypeCheck()),
    SETTER_SHOULD_HAVE_VOID_RETURN_TYPE(new SetterShouldHaveVoidReturnType()),
    GETTER_SHOULD_RETURN_REFERENCED_FIELD_VALUE(new GetterShouldRetrieveValueFromField()),
    SETTER_SHOULD_AFFECT_REFERENCED_FIELD(new SetterShouldSetValueOnReferencedField()),
    SETTER_SHOULD_ONLY_AFFECT_REFERENCED_FIELD(new SetterShouldOnlyAffectReferencedField());

    private final GetterSetterCheck getterSettercheck;

    Validations(GetterSetterCheck getterSettercheck) {
        this.getterSettercheck = getterSettercheck;
    }

    public GetterSetterCheck getGetterSettercheck() {
        return getterSettercheck;
    }
}
