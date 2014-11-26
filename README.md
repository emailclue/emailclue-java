emailclue-java
==============

Java Client Library

Create The Client
-----------------

Add the following static import to use our fluent API

```java
import static com.emailclue.api.EmailClue.*
```

Create an instance of the (thread safe) Client
```java
private final EmailClue emailClueClient = emailClueClient("12873782347TOKEN"));
```


Validating an email
-------------------
```java

```


Sending email
-------------
```java
emailClueClient.sendEmail(
        fromTemplate("TEMPLATE101")
                .to("dj.mabbett@gmail.com")
                .cc("triumph_2500@hotmail.com")
                .subject("Test Email")
                .data(templateData()))
```