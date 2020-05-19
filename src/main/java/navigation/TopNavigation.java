package navigation;

import element.AbstractElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AccountPage;
import page.AuthenticationPage;
import page.HomePage;
import page.SearchResultsPage;

public class TopNavigation extends AbstractElement {

    private final By searchField = By.id("search_query_top");
    private final By searchButton = By.cssSelector("button[name=submit_search]");
    private final By signInButton = By.className("login");
    private final By signOutButton = By.cssSelector("nav a.logout");
    private final By accountButton = By.className("account");

    public TopNavigation(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchFor(String searchTerm) {
        driver.findElement(searchField).sendKeys(searchTerm);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }

    //TODO: remove later
//    public HomePage switchToHomePage() {
//        return new HomePage(driver);
//    }

    public boolean isSignedIn() {
        return isPresent(signOutButton);
    }

    public boolean isSignedOut() {
        return isDisappeared(accountButton);
    }

    public AuthenticationPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new AuthenticationPage(driver);
    }

    public void signOut() {
        waitFor(signOutButton);
        driver.findElement(signOutButton).click();
    }

    public AccountPage goToMyAccount() {
        waitFor(accountButton);
        driver.findElement(accountButton);
        return new AccountPage(driver);
    }
}