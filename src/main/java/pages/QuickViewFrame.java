package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickViewFrame {

    private final WebDriver driver;
    private final By mainPicture = By.id("bigpic");

    public QuickViewFrame(WebDriver driver) {
        this.driver = driver;
    }

    public boolean bigPicIsDisplayed() {
        return driver.findElement(mainPicture).isDisplayed();
    }
}