package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage extends TopBase {

    private final By mainPicture = By.id("bigpic");
    private final By mainPictureOpened = By.cssSelector("div.fancybox-opened");
    private final By nextPictureLink = By.cssSelector("div.fancybox-opened a.fancybox-next");
    private final By closeMainPictureButton = By.cssSelector("a.fancybox-close");

    ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMainPictureDisplayed() {
        return isPresent(mainPicture);
    }

    public void openMainPicture() {
        driver.findElement(mainPicture).click();
    }

    public void closeMainPicture() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeMainPictureButton));
        driver.findElement(closeMainPictureButton).click();
    }

    public boolean isMainPictureClosed() {
        return isNotPresent(mainPictureOpened);
    }

    /**
     * @param times the number of times to
     *              click "next picture"
     */
    public void clickNextPicture(int times) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        for (int i = 0; i < times; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated(mainPictureOpened));
            driver.findElement(nextPictureLink).click();
        }
    }
}