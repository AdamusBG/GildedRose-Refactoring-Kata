# Gilded Rose Refactoring Kata

This Kata is forked from [here](https://github.com/emilybache/GildedRose-Refactoring-Kata).  

To clone my fork of this repo to your computer, please navigate to your desired directory from a terminal window and enter: `git clone https://github.com/AdamusBG/GildedRose-Refactoring-Kata.git`.  

## Java

I have worked on the kata in Java.

To run the tests, please navigate into the top level directory after cloning this repo to your computer and enter the following:

```
$ gradle test
$ open ./build/reports/tests/test/index.html
```

This will open a browser page with reports on my tests - note that the `gradle test` command may take some time to run.  

If you are unable to use `gradle`, it may not be installed on your computer. See [this](https://gradle.org/install/) website for help installing Gradle and [this](https://www.lambdatest.com/blog/run-junit-from-command-line/) website for information on JUnit testing with Gradle from the command line.  

### Planning

Before attempting to write or edit any code I carefully read both the specification and legacy code to create the below list of rules. Presented a little bit more clearly than in the specification.  

![update rules](./images/update_rules.png)

With the exception of rules relating to "conjured" items, I proved that all of these rules were implemented in the original code by creating 13 JUnit 5 tests. These had the additional benefit of informing me if any of the original functionality was lost by my updates.  

![initial tests](./images/initial_tests.png)

After refactoring the initial code and adding in the new functionality for "conjured" items, I added several tests to the existing test suite. This brings the total to 18 JUnit 5 tests.  

![final tests](./images/final_tests.png)
