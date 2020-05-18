package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage extends TopBase {

    // TODO: fields, that will not change, must be final.
    // TODO: rename variable (https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
    private By bigpic = By.id("bigpic");
    private By bigPicEnlarged = By.cssSelector("div.fancybox-opened");
    private By nextPicLink = By.cssSelector("div.fancybox-opened a.fancybox-next");
    private By closeBigPic = By.cssSelector("a.fancybox-close");

    ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean bigPicIsDisplayed() {
        return isPresent(bigpic);
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
        return isNotPresent(bigPicEnlarged);
    }

    public void clickNextBigPic(int times) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        for (int i = 0; i < times; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated(bigPicEnlarged));
            driver.findElement(nextPicLink).click();
        }
    }
}