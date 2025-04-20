package pages;

import org.openqa.selenium.By;

public class ProductPage extends MainPage {


    private final By btnBack = By.xpath("//button[@class='inventory_details_back_button']");
    private final By lblProductName = By.xpath("//div[@class='inventory_details_name']");
    private final By lblProductPrice = By.xpath("//div[@class='inventory_details_price']");
    private final By btnAddToCart = By.xpath("//div[@class='inventory_details_desc_container']//button");

    @Override
    public void verifyPageLoaded() {
        verifyElementsAreVisible(btnBack, lblProductName, lblProductPrice, btnAddToCart);
        verifyButtonAddToCartIsToggled(true);
    }

    public void clickButtonBack() {
        click(btnBack);
    }

    public void clickButtonAddToCart() {
        click(btnAddToCart);
    }

    public void verifyButtonAddToCartIsToggled(boolean isToggledActive) {
        if (isToggledActive) {
            assert find(btnAddToCart).getText().equals("REMOVE");
        } else {
            assert find(btnAddToCart).getText().equals("ADD TO CART");
        }
    }

    public void verifyProductName(String name) {
        String productName = GetText(lblProductName);
        assert productName.equals(name);
    }

    public void verifyProductPrice(String price) {
        String productPrice = GetText(lblProductPrice);
        assert productPrice.equals(price);
    }
}
