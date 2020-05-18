package account;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTests extends BaseTests {

    @Test
    public void testCreateWishlist() {
        var login = homePage.clickSignIn();
        login.logIn("9jsmith@garcia.com", "6c1Ca");
        var account =  homePage.goToMyAccount();
        var wishlist = account.goWishLists();
        wishlist.createWishList("test");
        assertTrue(wishlist.isWishlistPresent("test"), "Wishlist not created");
        homePage.signOut();
    }

    @Test(dependsOnMethods = "testCreateWishlist")
    public void testDeleteWishlist() {
        var login = homePage.clickSignIn();
        login.logIn("9jsmith@garcia.com", "6c1Ca");
        var account =  homePage.goToMyAccount();
        var wishlist = account.goWishLists();
        wishlist.deleteWishlist("test");
        assertTrue(wishlist.hasWishListDisappeared("test"), "Wishlist not deleted");
        homePage.signOut();
    }
}