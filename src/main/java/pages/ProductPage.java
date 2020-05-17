package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage extends TopBase {

    private By bigpic = By.id("bigpic");
    private By bigPicOpened = By.cssSelector("div.fancybox-opened");
    private By nextBigpic = By.cssSelector("div.fancybox-opened a.fancybox-next");
    private By closeBigPic = By.cssSelector("a.fancybox-close");

    ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean bigPicIsDisplayed() {
        return driver.findElement(bigpic).isDisplayed();
    }

    public void clickBigPic() {
        driver.findElement(bigpic).click();
    }

    public void closeBigPic() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeBigPic));
        driver.findElement(closeBigPic).click();
    }

    public boolean bigPicIsClosed() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(bigPicOpened));
        } catch (TimeoutException e) {
            return true;
        }
        return false;
    }

    public void clickNextBigPic(int times) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        for (int i = 0; i < times; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated(bigPicOpened));
            driver.findElement(nextBigpic).click();
        }
    }
}