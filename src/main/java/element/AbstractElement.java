package element;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class AbstractElement {

    public static final int TIMEOUT = 5;
    protected WebDriver driver;

    public AbstractElement(WebDriver driver) {
        this.driver = driver;
    }
    protected boolean isPresent(By element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    protected boolean isNotPresent(By element) {
        try {
            driver.findElement(element);
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    protected boolean isDisappeared(By element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    protected void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected boolean isDisappeared(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
