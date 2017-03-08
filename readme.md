Getter/Setter Verifier
==========
[![Build Status](https://travis-ci.org/TomCools/GetterSetterVerifier.png?branch=master)](https://github.com/TomCools/GetterSetterVerifier)

*Testing it so you don't have to.*

...euhm... WHY?
---
It is general knowledge to *Not Test Simple Getters and Setters*. But when are they no longer simple?
We often run into logic-creep in our getters or setters because "it's easier this way", "the rookie coded it" or any other reason.
This leads unknowingly adjusting state when calling a getter or not adjusting the state you expect in a setter.
We don't write tests for them because writing those tests takes a lot of work for next to no benefit.

This library has the intention to make it easy to test Getters and Setters.
Because if it's easy to test them... why wouldn't you?

What kinds of tests do you run?
---
The rules we check (not final) are:
- Getter/Setter should reference a field. (Have the same name without the get/set-prefix and must start with a small letter.
- Getter/Setter should be public
- Getter should not have a parameter and should return same type as backing field
- Setter should have exactly one parameter of the same type as the backing field and should have void return type
- Setter should only affect the backing field to which is is related and should set the field with the parameter value
- Getter should return an equal object as the backing field. The test checks, if the returned object is equal to the
  backing field. This is handled, as the object might be wrapped into an unmodifiable object (e.g. Collections) to
  avoid giving access to the implementation field.

Configuration
---
Testing a class with the default settings (all rules enabled):

GetterSetterVerifier
                .forClass(CompletelyValidClass.class)
                .verify();

Excluding rules:

GetterSetterVerifier
                .forClass(CompletelyValidClass.class)
                .excludeChecks(Validations.GETTER_SHOULD_BE_PUBLIC)
                .verify();

Need help? Found an issue? Want extra functionality?
---
Please report any issues you find. I will frequently check and update if required.
Please use following guidelines when posting:

* Check existing issues to see if it has been addressed already;
* In issues include the Bundle-version as well as the version of Dropwizard you are using;
* Add a description of how someone else can reproduce the problem and add the stacktrace if possible.