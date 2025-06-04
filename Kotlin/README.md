# Gilded Rose starting position in Kotlin

## Run the Text Fixture from Command-Line

```bash
mvn exec:java -Dexec.mainClass="com.gildedrose.TexttestFixtureKt" -Dexec.args="30"
```

### Specify Number of Days

For example, 10 days:

```bash
mvn exec:java -Dexec.mainClass="com.gildedrose.TexttestFixtureKt" -Dexec.args="10"
```

You should make sure the Maven commands shown above work when you execute them in a terminal before trying to use TextTest (see below).

## Run the TextTest approval test that comes with this project

There are instructions in the [TextTest Readme](../texttests/README.md) for setting up TextTest. What's unusual for the Java version is there are two executables listed in [config.gr](../texttests/config.gr) for Java. One uses Maven (via `exec:java`) wrapped in a Python script, the other relies on your CLASSPATH being set correctly in [environment.gr](../texttests/environment.gr).

