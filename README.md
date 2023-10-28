# Automation Testing Framework using Java, Selenium, Cucumber, and Maven

This repository contains an automation testing framework built using Java, Selenium, Cucumber, and Maven. This framework allows you to automate the testing of web applications and provides a structured approach for behavior-driven development (BDD).

## Prerequisites

Before you get started with this automation framework, you should have the following software and tools installed on your system:

- Java Development Kit (JDK)
- Maven
- Your favorite Java Integrated Development Environment (IDE)
- Web browsers such as Chrome or Firefox
- Required IDE Plugins:
  - Maven 
  - Cucumber
  - Selenium
- Browser driver (Ensure that you have the appropriate browser driver with correct versions for your desired browser and that the class path is correctly configured)

## Features

- **Java**: Java: The framework is built using Java programming language, providing the flexibility and robustness of Java for automation testing tasks.

- **Maven**: Apache Maven is used as a build and project management tool, simplifying the setup and dependency management of the project.

- **Selenium WebDriver**: Selenium WebDriver is used for web automation. You can write test scripts to interact with web elements in your web application.

- **Cucumber**: Cucumber is used to write behavior-driven development (BDD) tests in a Gherkin format, making it easier for non-technical stakeholders to understand test scenarios.

- **Page Object Model (POM)**: The framework follows the Page Object Model design pattern to enhance test code maintainability and reusability.

- **Reporting**: It includes reporting functionality for clear test result visualization.

## Getting Started
To set up the framework, you can either fork or clone the repository from here, or download the ZIP file and set it up in your local workspace.

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/ChamiHewa/AngloSDETassessment.git

2. Install dependencies:

   ```bash
   mvn clean install

3. Run tests:

   ```bash
   mvn test

## Reporting

A html report have been created as the default reporting method and generated report stores in the src/test/resources/reports/ directory

## Project Structure
- **src/main/java:** Contains the Java source files for utility classes and other helper functions.
- **src/test/java:** Contains page objects, step definitions and hooks for defining test scenarios.
- **src/test/resources:** Includes Cucumber feature files,reports, drivers and other resources used in the tests.

## Writing Tests

1. Create feature files in the **src/test/resources/features** directory using Gherkin syntax.
2. Implement step definitions in Java under the **src/test/java/stepDefinitions** package.
3. Run the tests using **mvn test**.

## License
This project is licensed under the MIT License.