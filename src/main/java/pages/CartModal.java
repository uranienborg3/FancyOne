package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.TopBase.TIMEOUT;

public class CartModal {

    private final WebDriver driver;
    private final By header = By.cssSelector("#layer_cart div.layer_cart_product h2");

    public CartModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessHeader() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return driver.findElement(header).getText();
    }
}