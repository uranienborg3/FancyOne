package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopBase {

    protected WebDriver driver;
    private By searchField = By.id("search_query_top");
    private By searchButton = By.cssSelector("button[name=submit_search]");
    private By signInButton = By.className("login");
    private By signOutButton = By.cssSelector("nav a.logout");

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
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    protected boolean isNotPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            return true;
        }
        return false;
    }

    public boolean isSignedIn() {
        return isPresent(signOutButton);
    }

    public void signOut() {
        waitFor(signOutButton);
        driver.findElement(signOutButton).click();
    }

    protected void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
