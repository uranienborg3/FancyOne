package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends TopBase {

    // TODO: fields, that will not change, must be final.
    private By createAccountForm = By.id("create-account_form");
    private By logInFrom = By.id("login_form");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitLoginButton = By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean createAccountPresent() {
        return isPresent(createAccountForm);
    }

    public boolean logInPresent() {
        return isPresent(logInFrom);
    }

    private void typeInto(By element, String text) {
        waitFor(element);
        driver.findElement(element).sendKeys(text);
    }

    public void logIn(String email, String password) {
        typeInto(emailField, email);
        typeInto(passwordField, password);
        driver.findElement(submitLoginButton).click();
    }
}