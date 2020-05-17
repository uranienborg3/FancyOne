package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickViewFrame {

    private WebDriver driver;
    private By bigPic = By.id("bigpic");

    public QuickViewFrame(WebDriver driver) {
        this.driver = driver;
    }

    public boolean bigPicIsDisplayed() {
        return driver.findElement(bigPic).isDisplayed();
    }
}