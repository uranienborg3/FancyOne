package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TODO: super class must be abstract
public abstract class TopBase {

    protected WebDriver driver;
    private final By searchField = By.id("search_query_top");
    private final By searchButton = By.cssSelector("button[name=submit_search]");
    private final By signInButton = By.className("login");
    private final By signOutButton = By.cssSelector("nav a.logout");
    private final By accountButton = By.className("account");
    public static final int TIMEOUT = 5;

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

    protected boolean isPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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

    protected boolean isDisappeared(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
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

    protected void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public AccountPage goToMyAccount() {
        waitFor(accountButton);
        driver.findElement(accountButton);
        return new AccountPage(driver);
    }
}