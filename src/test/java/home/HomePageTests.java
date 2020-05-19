package home;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTests extends BaseTests {

    @Test
    public void testSearchOnHomePage() {
        var search = homePage.searchFor("dress");
        assertEquals(search.getNumberOfSearchResults(), 7,
                "Search results not loaded");
    }

    @Test
    public void testViewProductDetails() {
        var home = homePage.switchToHomePage();
        var product = home.viewProductDetails(1);
        assertTrue(product.isMainPictureDisplayed(), "Not on product page");
    }

    @Test
    public void testQuickViewProduct() {
        var home = homePage.switchToHomePage();
        var quickView = home.quickViewProduct(2);
        assertTrue(quickView.bigPicIsDisplayed(), "Quick view product failed");
    }

    @Test
    public void testAddProductToCart() {
        var home = homePage.switchToHomePage();
        var modal = home.addProductToCart(3);
        assertEquals(modal.getSuccessHeader(), "Product successfully added to your shopping cart",
                "Product not added to cart");
    }

    @Test
    public void testGoToLogIn() {
        var login = homePage.clickSignIn();
        assertTrue(login.isCreateAccountFormPresent(), "No create account form: probably not a login page");
        assertTrue(login.isLogInFormPresent(), "No login form: probably not a login page");
    }

    @Test
    public void testChangeToBestSellersTab() {
        var home = homePage.switchToHomePage();
        var productsBeforeChanging = home.getProductList();
        home.switchToBestSellersTab();
        var productsAfterChanging = home.getProductList();
        assertNotEquals(productsBeforeChanging, productsAfterChanging,
                "Lists are the same: probably tabs did not change");
    }
}