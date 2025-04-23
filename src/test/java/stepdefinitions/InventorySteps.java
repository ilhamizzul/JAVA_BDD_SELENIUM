package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;
import pages.LoginPage;

public class InventorySteps {
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    int index;

    @Given("user already logged in successfully")
    public void userisLoggedIn() {
        loginPage.navigateToLoginPage();
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("user add product to cart")
    public void userAddProductToCart() {
        index = inventoryPage.clickButtonAddToCart();
    }

    @Then("product is added to cart")
    public void verifyProductAddedToCart() {
        inventoryPage.verifyProductAddedToCart();
    }

    @Then("inventory page is fully loaded")
    public void verifyInventoryPageIsLoaded() {
        inventoryPage.verifyPageLoaded();
        inventoryPage.verifyIsButtonItemInRemoveState(index);
    }

    @And("\"ADD TO CART\" button is changed to \"REMOVE\"")
    public void verifyButtonItemInRemoveState() {
        inventoryPage.verifyIsButtonItemInRemoveState(index);
    }
}
