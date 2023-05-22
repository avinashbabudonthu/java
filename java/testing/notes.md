# Testing Methodologies
## Functional Testing
* Unit Testing
* Integration/System Testing
* Acceptance Testing
* Regression Testing

## Non functional Testing
* Performance Testing
* Load Testing
* Stress Testing
* Volume Testing
* Security Testing
* Usability Testing
* Compatibility Testing
* Installation Testing
* Uninstallation Testing
* Recovery Testing
* Documentation Testing

## Unit Testing
* Unit testing is part of the software development process in which small parts of an application, called units, are individually tested for proper operation. Unit testing can be done manually but is often automated in Agile and DevOps projects.

## Integration/System Tests
* Integration testing is the part in software testing in which individual software modules are combined and tested as a group. It occurs after unit testing and before functional testing

## Functional Tests
* After the integration tests are performed, more complex levels of tests are used. The functional testing process in which software is tested to ensure that it conforms with all business requirements and to ensure that it has all the required functionality for the software to be used by the end user without issues

## Regression Tests
* Regression testing verifies that software which was developed in previous releases still performs correctly after it was changed, changes may include software enhancements, compliance, bug fixes etc

## Acceptance Tests
* Acceptance Testing is where a system is tested for acceptability by the end user. The purpose of this test is to evaluate the system's compliance with the business requirements and assess whether it is acceptable for delivery into production

## References
* https://smartbear.com/learn/automated-testing/software-testing-methodologies/
* https://www.softwaretestinghelp.com/software-development-testing-methodologies/
------
# Smoke Testing vs Sanity Testing
## What Is Sanity Testing
* To understand sanity testing, let’s first understand software build. A software project usually consists of thousands of source code files. It is a complicated and time-consuming task to create an executable program from these source code files. The process to create an executable program uses “build” software and is called `Software Build`
* Sanity testing is performed to check if new module additions to an existing software build are working as expected and can pass to the next level of testing. It is a subset of regression testing and evaluates the quality of regressions made to the software
* The main purpose of Sanity testing is to verify that the changes or the proposed functionality are working according to plan. Suppose there are minor changes to be made to the code, the sanity test further checks if the end-to-end testing of the build can be performed seamlessly. However, if the test fails, the testing team rejects the software build, thereby saving both time and money
* Sanity testing is performed once the smoke test has been cleared and accepted by the Quality Assurance team. During this testing, the primary focus is on validating the functionality of the application rather than performing detailed testing. When sanity testing is done for a module or functionality or complete system, the test cases for execution are so selected that they will touch only the important bits and pieces. Thus, it is wide but shallow testing

## What Is Smoke Testing
* Smoke Testing is carried out post software build in the early stages of SDLC (software development life cycle) to reveal failures, if any, in the pre-released version of a software. The testing ensures that all core functionalities of the program are working smoothly and cohesively. A similar test is performed on hardware devices to ensure they don’t release smoke when induced with a power supply. Thus, the test gets its name ‘smoke test’. It is a subset of acceptance testing and is normally used in tester acceptance testing, system testing, and integration testing. 
* The intent of smoke testing is not exhaustive testing but to eliminate errors in the core of the software. It detects errors in the preliminary stage so that no futile efforts are made in the later phases of the SDLC. The main benefit of smoke testing is that integration issues and other errors are detected, and insights are provided at an early stage, thus saving time.   
* For instance, a smoke test may answer basic questions like “does the program run?”, does the user interface open?”. If this fails, then there’s no point in performing other tests. The team won’t waste further time installing or testing. Thus, smoke tests broadly cover product features within a limited time. They run quickly and provide faster feedback rather than running more extensive test suites that would naturally require much more time. 
* A smoke test can be performed manually or by using automated tools. In the case of automated smoke tests, the process that generates the build will frequently initiate the testing. Automation helps run the tests quicker, resulting in faster feedback so you can act upon them immediately

## Sanity Testing vs. Smoke Testing
* Smoke and Sanity Testing are both rapid in checking core functionalities of the code besides checking eligibility for further tests. However, while smoke testing ensures that acute functionalities of a program are working fine, sanity testing checks that the proposed functionality works as expected. 
* Most of the time, we get confused between smoke testing and sanity testing. To clear such confusion, let’s explore the differences between the two testing methods in detail.
    * The goal of Smoke testing is to verify stability, whereas the goal of Sanity testing is to verify rationality. 
    * Software Developers or Testers perform smoke testing, whereas testers alone perform sanity testing.
    * The purpose of smoke testing is to verify the critical functionalities of a system, while sanity testing verifies the new functionality such as bug fixes
    * Smoke testing is a subset of acceptance testing, while sanity testing is a subset of regression testing.
    * Smoke testing is documented or scripted, while sanity testing is not. 
    * In smoke testing, the entire system is verified from end to end. In sanity testing, on the other hand, only a particular component of the system gets verified. 
    * Smoke test is done to make sure that the critical functionalities of the program are working fine, whereas sanity testing is done to check that newly added functionalities, bugs, etc., have been fixed.
    * The software build may be either stable or unstable during smoke testing. The software build is relatively stable at the time of sanity testing. 
    * Smoke testing is done on initial builds, while sanity testing is done on relatively stable builds 
    * Smoke testing is done as a part of basic testing, whereas sanity testing is done as part of regression testing.
    * Smoke testing is usually done every time there is a new build release. But sanity testing is planned when there is not sufficient time for in-depth testing.
    * Smoke testing is like a general health checkup, while sanity testing resembles a specialized health checkup.
* That was all about the differences in sanity testing vs smoke testing. 
* According to testing needs, you may have to carry out both sanity and smoke tests in the software build. In such scenarios, the smoke test is first performed, followed by the sanity test. In industry, test cases for sanity testing are frequently combined with test cases for smoke tests to ensure faster test execution. This leads to the terms being often confused and used interchangeably.
------