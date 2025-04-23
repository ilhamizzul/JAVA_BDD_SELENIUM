package stepdefinitions;

import io.cucumber.java.en.*;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();

    @Given("the user is on the login page")
    public void navigateToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("the user enters valid username {string} and password {string}")
    @When("the user enters invalid username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
    }

    @And("clicks the login button")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the Inventory Page")
    public void validateLoginSuccess() {
        inventoryPage.verifyPageLoaded();
    }

    @Then("the error message {string} should be displayed")
    public void verifyErrorMessage(String message) {
        loginPage.verifyErrorMessage(message);
    }
}
