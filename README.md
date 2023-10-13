# SolutionMakers-BDD (Amazon Automation Testing Framework)

## Overview
This is a sample project to demonstrate the page object model framework and how it can used in Selenium to automate an application.
TestNG is used as a test framework with the BDD approach and Cucumber with Gherkin

## Project Structure

amazon-automation
├── src
│ ├── main
│ │ ├── java
│ │ │ ├── (Java source files for your main application code)
│ │ │
│ │ ├── resources
│ │ ├── (Configuration files, application properties, etc.)
│ │
│ ├── test
│ ├── java
│ │ ├── (Java source files for your test code)
│ │
│ ├── resources
│ ├── (Cucumber feature files, test data, etc.)
│
├── pom.xml (Maven Project Object Model file)
├── README.md

## Features

- **BDD and TDD Integration**: We utilize Cucumber for BDD, allowing you to write feature files in plain English and TestNG for TDD to write traditional test cases.

- **Page Object Model (POM)**: We implement the Page Object Model design pattern to create maintainable and reusable web elements.

- **Cross-Browser Testing**: The framework supports testing on multiple web browsers (e.g., Chrome, Firefox).

- **Parallel Test Execution**: Achieve faster test execution by running tests in parallel using TestNG.

- **Reporting**: Generate detailed and user-friendly test reports with screenshots of failed steps using Extent Reports.

## Prerequisites

Before you start, ensure you have the following tools and software installed:

- Java Development Kit (JDK)
- Apache Maven
- A compatible web browser (e.g., Chrome, Firefox)

## Getting Started

1. Clone this repository to your local machine.

2. Configure your test environment by updating the properties in the configuration files in the `src/main/resources` directory.
   
Run your tests by executing the following command: mvn test

View test reports generated in the test-output directory.

Writing Tests :
Write your BDD feature files in the src/test/resources directory using Cucumber syntax.

Implement step definitions in the src/test/java directory.

## Customization
Feel free to customize this framework to suit your specific testing requirements. You can add more features, and integrations, or modify the existing codebase.

## Contributor
- Supriya Yadav
