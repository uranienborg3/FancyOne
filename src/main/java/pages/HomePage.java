package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends TopBase {

    private By productBox = By.cssSelector("#homefeatured li");
    private By moreButton = By.cssSelector("a.button.lnk_view");
    private By addToCartButton = By.cssSelector("a.ajax_add_to_cart_button");
    private By quickViewButton = By.className("quick-view");
    private By iFrame = By.className("fancybox-iframe");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * @param index 1-based
     */
    public ProductPage viewProductDetails(int index) {
        WebElement product = getProductElement(index);
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
        product.findElement(moreButton).click();
        return new ProductPage(driver);
    }

    public QuickViewFrame quickViewProduct(int index) {
        WebElement product = getProductElement(index);
        showButtons(product);
        product.findElement(quickViewButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        return new QuickViewFrame(driver);
    }

    public CartModal addProductToCart(int index) {
        WebElement product = getProductElement(index);
        showButtons(product);
        product.findElement(addToCartButton).click();
        return new CartModal(driver);
    }

    private void showButtons(WebElement product) {
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
    }

    private WebElement getProductElement(int index) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productBox));
        List<WebElement> allProductsList = driver.findElements(productBox);
        return allProductsList.get(index - 1);
    }
}
