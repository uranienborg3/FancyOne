package home;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTests extends BaseTests {

    @Test
    public void testSearchOnHomePage() {
        var search = topbase.searchFor("dress");
        assertEquals(search.getNumberOfSearchResults(), 7,
                "Search results not loaded");
    }

    @Test
    public void testViewProductDetails() {
        var home = topbase.switchToHomePage();
        var product = home.viewProductDetails(1);
        assertTrue(product.bigPicIsDisplayed(), "Not on product page");
    }

    @Test
    public void testQuickViewProduct() {
        var home = topbase.switchToHomePage();
        var quickView = home.quickViewProduct(2);
        assertTrue(quickView.bigPicIsDisplayed(), "Quick view product failed");
    }

    @Test
    public void testAddProductToCart() {
        var home = topbase.switchToHomePage();
        var modal = home.addProductToCart(3);
        assertEquals(modal.getSuccessHeader(), "Product successfully added to your shopping cart",
                "Product not added to cart");
    }
}