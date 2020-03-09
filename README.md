# Engineering Coding Challenge

## Refer the LME - Coding Challenge.pdf for the Question

### Assumptions

The movement of the Robot is based on the Robot's Point of View (POV) based on its orientation.

### Deviations
The following deviations are taken in order to focus on the main problem.

The input is not taken as multiple lines on the Command line. The input is used directly in the App.java's main method.

The orientation of the Robot determines the direction from the point of view of the Robot. Hence, a Left from North is a different coordinate than a Left from South. Hence, the sample input data provided with the question resulted in a answer from the POV of Robot.

### Pre-requisites for running the program

A Gradle 5.2.1 and Java 11 should be sufficient.

``` .gradlew clean build``` should build and execute the tests.
More commands can be provided from the App.java to test multiple scenarios.

### Intellij usage
If you are using IntelliJ, please remember to enable annotation processor and exclude the generated path 


 
