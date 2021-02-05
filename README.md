# DD2480 Software Engineering Fundamentals (Group 13)

### Launch Interceptor Program
A hypothetical anti-ballistic missile system that decides if the launch button should be unlocked based on radar tracking information.

### Motivation
The motivation for this project was to learn about Software Fundamentals when developing software in teams. How to divide work, write proper commit messages and write tests were some of the goals.

### Build
Gradle is used to build the project.
```
./gradlew clean build run
```

### Tests
The file DecideTest contains all the unit tests for each function. To run it, the gradle task "customTest" is used.
```
./gradlew clean customTest
```

### File structure

The code for the Decide functionality is in app/src/main/java/Decide . The code for the test cases are in app/src/test/java/Decide

├── app
│   └── src
│       ├── main
│       │   └── java
│       │       └── Decide
│       │           ├── Decide.java
│       │           ├── LIC.java
│       │           └── MatrixCalc.java
│       └── test
│           └── java
│               └── Decide
│                   └── DecideTest.java
├── gradlew
├── gradlew.bat
├── README.md
└── settings.gradle


### Contributions

Amar - Wrote and tested the functions for LIC0, LIC1, LIC8, LIC9, LIC10, CMV and Decide. Integrated Gradle as our build tool, wrote the first README draft and made various refactoring of the code base.

Gustav - Code skeleton for Decide.java and DecideTest.java, smallest radius of three points method, LIC12, LIC13, LIC14, LIC7, refactoring LIC2, PUM method, FUV method

Petter - Wrote and tested the functions LIC2, LIC3, LIC4, LIC6, LIC11, and wrote formal tests for LIC3, LIC4, LIC6 and LIC11. Wrote description to all the tests.

Sida - Wrote and tested the functions LIC5.
