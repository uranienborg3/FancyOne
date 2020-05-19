package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends TopBase {

    private final By createAccountForm = By.id("create-account_form");
    private final By logInFrom = By.id("login_form");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("passwd");
    private final By submitLoginButton = By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCreateAccountFormPresent() {
        return isPresent(createAccountForm);
    }

    public boolean isLogInFormPresent() {
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