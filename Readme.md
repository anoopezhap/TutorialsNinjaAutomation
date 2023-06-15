# Selenium Hybrid Framework

This repository contains a hybrid automation framework built with Selenium, Java, and TestNG. The framework aims to provide a scalable and maintainable solution for automating "https://tutorialsninja.com/demo/" . It utilizes the power of Selenium WebDriver, TestNG for test execution, ExtentReports for generating comprehensive reports, and Maven for dependency management.

## Features

- **Hybrid approach**: The framework combines the best practices of data-driven and keyword-driven testing, providing flexibility and reusability.
- **Modular design**: It follows a modular structure, allowing easy organization and maintenance of test scripts and resources.
- **Page Object Model (POM)**: The framework adopts the POM design pattern, promoting separation of concerns and enhancing code maintainability.
- **Cross-browser testing**: It supports running tests on multiple browsers such as Chrome, Firefox, and Safari.
- **Reporting**: The framework integrates ExtentReports to generate detailed HTML reports with screenshots and test execution summaries.
- **TestNG integration**: It utilizes TestNG to manage test execution, parallel execution, and test configurations.
- **Dependency management**: The framework employs Maven for handling dependencies and building the project.
- **Integration with Jenkins**: The project can be easily integrated with Jenkins for continuous integration and automated builds.

## Prerequisites

To use this framework, ensure you have the following installed:
- Java Development Kit (JDK) version 8 or higher
- Maven (for managing dependencies and building the project)
- Chrome, Firefox, or Safari browser (depending on your test environment)
- Jenkins (optional, for integration)
- Excel(if you want to make changes to the testing data)

## Getting Started

To get started, follow these steps:

1. Clone this repository to your local machine:

```bash
https://github.com/anoopezhap/TutorialsNinjaAutomation.git
```
2. Import the project into your preferred Java IDE (e.g., IntelliJ, Eclipse).

3. Install the required dependencies by running the following command in the project root directory:

```bash
mvn clean install
```
4. Update the configuration file (`config.properties`) with your desired settings, such as browser type.

5. After successfully installing the project, you can run all the tests using the following command:
```bash
mvn test
```
This will execute all the test cases present in the project and generate test reports.

6. To integrate the project with Jenkins, create a new Jenkins job, configure it to pull the repository, and add the Maven command (mvn test) as a build step.

## Reporting
After executing the tests, the framework generates detailed HTML reports using ExtentReports. When the build is successful the HTML report will be automatically opened.






