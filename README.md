emailclue-java
==============

Java Client Library

[![Build Status](https://travis-ci.org/emailclue/emailclue-java.svg)](https://travis-ci.org/emailclue/emailclue-java)

Create The Client
-----------------

Add the following static import to use our fluent API

```java
import static com.emailclue.api.EmailClue.*;
```

Create an instance of the (thread safe) Client
```java
private final EmailClue emailClueClient = emailClueClient("12873782347TOKEN"));
```







Validating an email
-------------------
```java
Clue validationResult = emailClueClient.validate(
        email("test@example.com")
);
```


Sending email
-------------
```java
emailClueClient.sendEmail(
        fromTemplate("TEMPLATE101")
                .to("dj.mabbett@gmail.com")
                .cc("triumph_2500@hotmail.com")
                .subject("Test Email")
                .data(templateData())
);
```