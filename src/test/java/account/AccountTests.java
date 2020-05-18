package account;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTests extends BaseTests {

    @Test
    public void testCreateWishlist() {
        var login = topbase.clickSignIn();
        login.logIn("9jsmith@garcia.com", "6c1Ca");
        var account =  topbase.goToMyAccount();
        var wishlist = account.goWishLists();
        wishlist.createWishList("test");
        assertTrue(wishlist.wishlistPresent("test"), "Wishlist not created");
        topbase.signOut();
    }

    @Test(dependsOnMethods = "testCreateWishlist")
    public void testDeleteWishlist() {
        var login = topbase.clickSignIn();
        login.logIn("9jsmith@garcia.com", "6c1Ca");
        var account =  topbase.goToMyAccount();
        var wishlist = account.goWishLists();
        wishlist.deleteWishlist("test");
        assertTrue(wishlist.wishListDisappeared("test"), "Wishlist not deleted");
        topbase.signOut();
    }
}