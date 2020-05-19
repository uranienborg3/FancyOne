package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends TopBase {

    private final By productBox = By.cssSelector("ul.active li");
    private final By moreButton = By.cssSelector("a.button.lnk_view");
    private final By addToCartButton = By.cssSelector("a.ajax_add_to_cart_button");
    private final By quickViewButton = By.className("quick-view");
    private final By iFrame = By.className("fancybox-iframe");
    private final By bestSellersTab = By.className("blockbestsellers");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * @param index the number of a product on the page
     *              to view details of;
     *              starts with 1
     */
    public ProductPage viewProductDetails(int index) {
        WebElement product = getProductElement(index);
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
        product.findElement(moreButton).click();
        return new ProductPage(driver);
    }


    /**
     * @param index the number of a product on the page
     *              to quick view;
     *              starts with 1
     */
    public QuickViewFrame quickViewProduct(int index) {
        WebElement product = getProductElement(index);
        showButtons(product);
        product.findElement(quickViewButton).click();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        return new QuickViewFrame(driver);
    }


    /**
     * @param index the number of a product on the page
     *              to add to the cart;
     *              starts with 1
     */
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


    /**
     * @param index the number of a product on the page
     *              starts with 1
     */
    private WebElement getProductElement(int index) {
        //TODO: please, avoid "magic numbers". Use constants.
        return getProductList().get(index - 1);
    }

    public List<WebElement> getProductList() {
        return driver.findElements(productBox);
    }

    public void switchToBestSellersTab() {
        driver.findElement(bestSellersTab).click();
    }
}