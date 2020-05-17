package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBase {

    protected WebDriver driver;
    private By searchField = By.id("search_query_top");
    private By searchButton = By.cssSelector("button[name=submit_search]");

    public TopBase(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage searchFor(String searchTerm) {
        driver.findElement(searchField).sendKeys(searchTerm);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
    public HomePage switchToHomePage() {
        return new HomePage(driver);
    }
}
