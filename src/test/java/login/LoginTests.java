package login;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSignIn() {
        var loginPage = homePage.clickSignIn();
        loginPage.logIn("9jsmith@garcia.com", "6c1Ca");
        assertTrue(loginPage.isSignedIn(), "No SignOut button: probably not signed in");
    }

    @Test(dependsOnMethods = "testSignIn")
    public void testSignOut() {
        homePage.signOut();
        assertTrue(homePage.isSignedOut(), "Not signed out");
    }
}