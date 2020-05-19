package page;

import navigation.Navigable;
import navigation.TopNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultsPage extends TopNavigation implements Navigable {

    private final TopNavigation navigation;

    private final By productBox = By.cssSelector("ul.product_list > li");
    private final By dropDown = By.id("selectProductSort");
    private final By priceText = By.cssSelector("div.right-block .content_price span.price");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        navigation = new TopNavigation(driver);
    }

    public int getNumberOfSearchResults() {
        return getSearchResults().size();
    }

    @Override
    public TopNavigation provideNavigation() {
        return navigation;
    }

    /**
     * @param index the number of a product
     *              to get the price of;
     *              starts with 1
     * @return a string that is the price
     * displayed on a product
     */
    public String getPriceOf(int index) {
        WebElement product = getSearchResults().get(index - 1);
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