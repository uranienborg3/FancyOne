package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickViewFrame {

    // TODO: fields, that will not change, must be final.
    private WebDriver driver;
    private By bigPic = By.id("bigpic");

    public QuickViewFrame(WebDriver driver) {
        this.driver = driver;
    }

    public boolean bigPicIsDisplayed() {
        return driver.findElement(bigPic).isDisplayed();
    }
}