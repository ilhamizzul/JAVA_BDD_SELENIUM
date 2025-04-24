package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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

    @When("user remove product from cart")
    public void userRemoveProductFromCart() {
        index = inventoryPage.clickButtonRemoveItem();
    }
    @Then("product is added to cart")
    public void verifyProductAddedToCart() {
        inventoryPage.verifyProductAddedToCart();
        Assert.assertTrue(
                inventoryPage.verifyIsButtonItemInRemoveState(index),
                "Expected product button on index : " + index + " to have \"REMOVE\" text on the button but it is still \"ADD TO CART\" text."
        );
    }

    @Then("product is removed from cart")
    public void verifyProductRemovedFromCart() {
        Assert.assertTrue(
                inventoryPage.verifyIsButtonItemInAddToCartState(index),
                "Expected button on index : " + index + " to have \"ADD TO CART\" text on the button but it is still \"REMOVE\" text."
        );
    }

    @Then("inventory page is fully loaded")
    public void verifyInventoryPageIsLoaded() {
        inventoryPage.verifyPageLoaded();
    }

    @And("\"ADD TO CART\" button is changed to \"REMOVE\"")
    @And("\"REMOVE\" button is changed to \"ADD TO CART\"")
    public void verifyButtonItemInRemoveState() {
        inventoryPage.verifyIsButtonItemInRemoveState(index);
    }
}
