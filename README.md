# INTRODUCTION

This Automation Framework using Java, Maven, Cucumber and Gherkin syntax.

1) Here is a list of some of the software you will probably need to install:
- Java 8: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
- Maven: https://maven.apache.org/
- IntelliJ IDEA (Community): https://www.jetbrains.com/idea/download/
    - plugins: cucumber, gherkin

2) Run Cucumber test (command line):
 ```
 > mvn clean compile test
 ```
Out end-to-end test should be executed successfully.
The report will be generated in test-output/HtmlReport/ directory with the name of ExtentHtml.html.

