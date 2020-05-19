package account;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTests extends BaseTests {

    @Test
    public void testCreateWishlist() {
        var login = homePage.provideNavigation().clickSignIn();
        login.logIn("9jsmith@garcia.com", "6c1Ca");
        var account =  login.provideNavigation().goToMyAccount();
        var wishlist = account.goToWishLists();
        wishlist.createWishList("test");
        assertTrue(wishlist.isWishlistPresent("test"), "Wishlist not created");
        wishlist.provideNavigation().signOut();
    }

    @Test(dependsOnMethods = "testCreateWishlist")
    public void testDeleteWishlist() {
        var login = homePage.provideNavigation().clickSignIn();
        login.logIn("9jsmith@garcia.com", "6c1Ca");
        var account =  login.provideNavigation().goToMyAccount();
        var wishlist = account.goToWishLists();
        wishlist.deleteWishlist("test");
        assertTrue(wishlist.hasWishListDisappeared("test"), "Wishlist not deleted");
        wishlist.provideNavigation().signOut();
    }
}