package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    // navbar
    private final By divLogo = By.xpath("//div[@class='app_logo']");
    private final By btnCart = By.xpath("//a[@href='./cart.html']");
    protected final By lblCartBadge = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
    private final By btnBurger = By.xpath("//div[@class='bm-burger-button']");
    // sidebar
    private final By divSidebarMenu = By.xpath("//div[@class='bm-menu']");
    private final By lnkAllItems = By.xpath("//a[@id='inventory_sidebar_link']");
    private final By lnkAbout = By.xpath("//a[@id='about_sidebar_link']");
    private final By lnkLogout = By.xpath("//a[@id='logout_sidebar_link']");
    private final By btnClose = By.xpath("//button[normalize-space()='Close Menu']");

    //Footer
    private final By footer = By.xpath("//footer[@class='footer']");
    private final By divFooter = By.xpath("//div[@class='footer_copy']");

    public void verifyPageLoaded() {
        verifyElementsAreVisible(divLogo, btnCart, btnBurger);
        scrollDownByPixel(driver, 250);
        verifyElementsAreVisible(footer, divFooter);
    }

    public void verifyProductAddedToCart() {
        verifyElementsAreVisible(lblCartBadge);
    }

    public void clickButtonCart() {
        click(btnCart);
    }

    public void clickButtonBurger() {
        click(btnBurger);
    }

    public void clickButtonCloseSidebar() {
        click(btnClose);
    }

    public void clickLinkAllItems() {
        if (verifyElementsAreVisible(divSidebarMenu)) {
            click(lnkAllItems);
        } else {
            clickButtonBurger();
            click(lnkAllItems);
        }
    }

    public void clickLinkAbout() {
        if (verifyElementsAreVisible(divSidebarMenu)) {
            click(lnkAbout);
        } else {
            clickButtonBurger();
            click(lnkAbout);
        }
    }

    public void clickLinkLogout() {
        if (verifyElementsAreVisible(divSidebarMenu)) {
            click(lnkLogout);
        } else {
            clickButtonBurger();
            click(lnkLogout);
        }
    }


}
