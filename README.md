# Geb / Gradle Example Project

Example project of running Geb tests with Gradle.

To run the tests in Firefox (requires Firefox v47.0.1 installed), execute:

```
gradlew test
```

To run the tests in Chrome, execute:

```
gradlew test -Dgeb.env=chrome
```