package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickViewFrame extends AbstractElement {

    private final By mainPicture = By.id("bigpic");

    public QuickViewFrame(WebDriver driver) {
        super(driver);
    }

    public boolean bigPicIsDisplayed() {
        return driver.findElement(mainPicture).isDisplayed();
    }
}