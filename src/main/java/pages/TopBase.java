package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TODO: super class must be abstract
public class TopBase {

    // TODO: fields, that will not change, must be final.
    protected WebDriver driver;
    private By searchField = By.id("search_query_top");
    private By searchButton = By.cssSelector("button[name=submit_search]");
    private By signInButton = By.className("login");
    private By signOutButton = By.cssSelector("nav a.logout");
    private By accountButton = By.className("account");

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

    public AuthenticationPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new AuthenticationPage(driver);
    }

    //TODO: nice naming =)
    protected boolean isPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    // TODO: rename argument.
    protected boolean isNotPresent(By by) {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    // TODO: rename argument.
    protected boolean isDisappeared(By by) {
        //TODO: please, avoid "magic numbers". Use constants.
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    protected boolean isDisappeared(WebElement element) {
        //TODO: please, avoid "magic numbers". Use constants.
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isSignedIn() {
        return isPresent(signOutButton);
    }

    public boolean isSignedOut() {
        return isDisappeared(accountButton);
    }

    public void signOut() {
        waitFor(signOutButton);
        driver.findElement(signOutButton).click();
    }

    // TODO: rename argument.
    protected void waitFor(By by) {
        //TODO: please, avoid "magic numbers". Use constants.
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public AccountPage goToMyAccount() {
        waitFor(accountButton);
        driver.findElement(accountButton);
        return new AccountPage(driver);
    }
}