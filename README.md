# Java BDD Selenium Automation Framework

**Java BDD Selenium Automation Framework** is a Behavior-Driven Development (BDD) testing framework designed to automate web application testing. It leverages **Java**, **Selenium WebDriver**, and **Cucumber** to create human-readable test scenarios while supporting powerful browser interactions.

---

## 📖 Overview

This project helps test web applications by combining the simplicity of Cucumber's Gherkin syntax with the robustness of Selenium's automation capabilities. The framework uses the **Page Object Model** (POM) for modularized and reusable test code.

### Key Features:
- Behavior-driven development with Cucumber using `.feature` files.
- Selenium WebDriver for browser automation.
- Allure Reporting for detailed test execution reports.
- Gradle for dependency management and build automation.
- TestNG for assertions and test control.

---

## 🛠️ Tools & Technologies

- **Java**: Core language used in the project.
- **Selenium WebDriver**: For browser interaction and automation.
- **Cucumber**: Writing BDD test cases in Gherkin language.
- **TestNG**: For advanced assertion logic and reporting.
- **Gradle**: Build and dependency management tool.
- **Allure Report**: For detailed test execution reports.

---

## 📂 Project Structure

### 1. Pages
The **Page Object Model (POM)** is implemented to organize web elements and action methods related to specific pages in the application.

**Files:**
- `LoginPage.java`: Defines web elements and actions for Login functionality.
- `InventoryPage.java`: Manages elements and actions for the product inventory page.
- `MainPage.java`: Base class for shared logic and elements across pages.

---

### 2. Step Definitions
Step definition files implement the given, when, then steps in the `.feature` files. These files bridge the high-level scenarios with the methods from the page classes.

**Files:**
- `LoginSteps.java`: Implements the BDD steps for login scenarios.
- `InventorySteps.java`: Maps inventory-related BDD steps.

---

### 3. Feature Files
Feature files contain test cases written in the Gherkin language. These files drive the tests by describing the behavior and expected outcome of the application.

**Example files:**
- `TS01_Login.feature`: Contains scenarios for login functionality.
- `TS02_Inventory.feature`: Scenarios for managing product/item inventory.

---

### 4. Utilities (if applicable)
Reusable helper methods and configuration files to support testing. Examples include managing environment variables, common actions, or test data.

---

## 🚀 Getting Started

### Prerequisites

Make sure to have the following installed:
1. **Java JDK** (8 or higher).
2. **Gradle** (to build and run the project).
3. **Selenium WebDriver** (for the target browser like Chrome/Edge/Firefox).
4. A modern web browser (e.g., Chrome or Firefox).
5. **Allure Commandline Tool** (for generating and viewing the test report). Follow the [Allure Installation Guide](https://docs.qameta.io/allure/#_installing_a_commandline) to set it up.

---

### Running Tests

Follow the steps below:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/ilhamizzul/JAVA_BDD_SELENIUM.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd JAVA_BDD_SELENIUM
   ```
3. **Build the Project:**
   ```bash
   gradle build
   ```
4. **Run the Tests:**
   For all tests:
   ```bash
   gradle test
   ```
   For specific feature files or scenarios:
   ```bash
   gradle clean -Dcucumber.features=src/test/resources/features/<file-name>.feature
   ```

---

## 📊 Generating and Viewing the Allure Report

1. **Run the Tests with Allure Plugin:**  
   Make sure your `build.gradle` is configured to enable Allure Cucumber and TestNG integration. Add the following in your `dependencies` (if not already added):

   ```gradle
   plugins {
       id 'io.qameta.allure' version '2.11.2'
   }

   dependencies {
       testImplementation 'io.qameta.allure:allure-cucumber7-jvm:2.21.0'
       testImplementation 'io.qameta.allure:allure-testng:2.21.0'
   }
   ```

2. **Execute Tests:**  
   Run the tests using Gradle:
   ```bash
   gradle clean test
   ```

3. **Generate Allure Report:**  
   After the tests complete, generate the report using the command:
   ```bash
   allure generate build/allure-results --clean -o allure-report
   ```

4. **View Allure Report:**  
   Serve the report locally by running:
   ```bash
   allure serve build/allure-results
   ```

   This will open the Allure report in your default browser.

---

## ✔️ Sample Scenario

Here’s an example from the `TS01_Login.feature` file:

```gherkin
Feature: Login to the application

  Scenario: Login with valid credentials
    Given I am on the Login page
    When I enter valid username and password
    And I click on the Login button
    Then I should be redirected to the Inventory page
```

### Step Definition Example (`LoginSteps.java`):

```java
@Given("I am on the Login page")
public void navigateToLoginPage() {
    loginPage.openLoginPage();
}

@When("I enter valid username and password")
public void enterValidCredentials() {
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
}

@When("I click on the Login button")
public void clickLoginButton() {
    loginPage.clickLoginButton();
}

@Then("I should be redirected to the Inventory page")
public void verifyRedirectionToInventoryPage() {
    Assert.assertTrue(inventoryPage.isDisplayed());
}
```

---

## 📦 Dependencies

The project uses the following dependencies (managed via Gradle):

```gradle
dependencies {
    testImplementation 'org.seleniumhq.selenium:selenium-java:4.9.1'
    testImplementation 'io.cucumber:cucumber-java:7.14.0'
    testImplementation 'io.cucumber:cucumber-testng:7.14.0'
    testImplementation 'org.testng:testng:7.7.0'
    testImplementation 'io.qameta.allure:allure-cucumber7-jvm:2.21.0'
    testImplementation 'io.qameta.allure:allure-testng:2.21.0'
}
```

Run `gradle dependencies` to fetch them.

---

## 🤝 Contributing

Contributions are welcome! Please submit a pull request for bug fixes, improvements, or new test cases.

---

## 📧 Contact

For any issues, feedback, or support, please reach out to the project maintainer at [ilhamizzul@gmail.com].

---