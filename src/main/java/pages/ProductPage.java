package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends TopBase {

    private By bigpic = By.id("bigpic");

    ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean bigPicIsDisplayed() {
        return driver.findElement(bigpic).isDisplayed();
    }
}
