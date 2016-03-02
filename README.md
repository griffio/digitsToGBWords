### Digits To en_GB Words

The aim of this library is to store the digits of an integer up to a billion (exclusive) in a Value Object, encoded as en_GB "spoken" words

A new type "NineDigitGBWords" encapsulates nine digits from 0 to 9 inclusive (http://www.wolframalpha.com/input/?i=999999999).
This represents a "value" class and implements hashcode/equals/comparable of int and could be used as a field value in other domain objects.
Alternatives to boiler-plate, [AutoValue](https://github.com/google/auto/tree/master/value),[Data classes](https://kotlinlang.org/docs/reference/data-classes.html)
 
#### NineDigitEnGB

Wraps the int value and validates the constructor input to have the valid range.
This is the same idea as "Tiny Types" like a Postcode or Credit Card Number are domain types.

#### Usage

``` java
 
 
```

#### References
Some of the domain reference
https://en.wikipedia.org/wiki/Long_and_short_scales
http://www.wolframalpha.com/input/?i=999999999
http://www.blackwasp.co.uk/numbertowords_3.aspx

#### Test Libraries

[TestNg](http://testng.org/doc/index.html) for passing data to fixture tests
[Guava Test-lib](https://github.com/google/guava/tree/master/guava-testlib) for equality and comparator testing
[Google Truth](https://google.github.io/truth/) for assertions

As this is designed to be a library, it should be integrated through a repository manager, such as [Artifactory](https://www.jfrog.com/artifactory/).

The [Nebula](https://github.com/nebula-plugins) plugin is used to create the Maven POM format and publish a source jar.

Project requires Java 8

#### Fixture data

```
   Digit  | Words
------------------------------------------------------------------------------------------------------------------
        0 |	zero
        1	| one
       42	| forty one
      109	| one hundred and nine
      125	| one hundred and twenty five
     1001 | one thousand and one
     1025 | one thousand and twenty five
     1107 | one thousand one hundred and seven
    99999 | ninety nine thousand nine hundred and ninety nine
 46945671	| forty six million nine hundred and forty five thousand five hundred and seventy one
999999999	| nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine
```
