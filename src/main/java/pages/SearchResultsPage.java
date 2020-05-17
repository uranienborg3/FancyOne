package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends TopBase {

    private By productBox = By.cssSelector("ul.product_list > li");
    private By dropDown = By.id("selectProductSort");
    private By priceText = By.cssSelector("div.right-block .content_price span.price");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfSearchResults() {
        return getSearchResults().size();
    }

    /**
     * @param index 1-based
     * @return returns a string that is the price
     * displayed on a product
     */
    public String getPriceOf(int index) {
        WebElement product = getSearchResults().get(index - 1);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(priceText));
        return product.findElement(priceText).getText();
    }

    public void sortSearchResults(String sortByText) {
        Select dropdown = new Select(driver.findElement(dropDown));
        dropdown.selectByVisibleText(sortByText);
    }

    private List<WebElement> getSearchResults() {
        return driver.findElements(productBox);
    }
}
