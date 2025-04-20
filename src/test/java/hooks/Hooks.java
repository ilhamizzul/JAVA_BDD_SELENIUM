package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.WebDriverConfig;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
