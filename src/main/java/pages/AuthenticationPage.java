package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AuthenticationPage extends TopBase {

    private By createAccountForm = By.id("create-account_form");
    private By logInFrom = By.id("login_form");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean createAccountPresent() {
        waitFor(createAccountForm);
        return isPresent(createAccountForm);
    }

    public boolean logInPresent() {
        waitFor(createAccountForm);
        return isPresent(logInFrom);
    }

    private void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
