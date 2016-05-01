Getter/Setter Verifier
==========

*Testing it so you don't have to.*

...euhm... WHY?
---
It is general knowledge to *Not Test Simple Getters and Setters*. But when are they no longer simple?
We often run into logic-creep in our getters or setters because "it's easier this way", "the rookie coded it" or any other reason.
This leads unknowingly adjusting state when calling a getter or not adjusting the state you expect in a setter.
We don't write tests for them because writing those tests takes a lot of work for next to no benefit.

This library has the intention to make it easy to test Getters and Setters.
The rules we check are:
- TO BE ADDED


Configuration
---
TO BE ADDED


    
Need help? Found an issue? Want extra functionality?
---
Please report any issues you find. I will frequently check and update if required.
Please use following guidelines when posting:

* Check existing issues to see if it has been addressed already;
* In issues include the Bundle-version as well as the version of Dropwizard you are using;
* Add a description of how someone else can reproduce the problem and add the stacktrace if possible.