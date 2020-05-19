package product;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductPageTests extends BaseTests {
    @Test
    public void testViewPictureInLarge() {
        var product = homePage.viewProductDetails(3);
        assertTrue(product.isMainPictureDisplayed(), "Big pic is not there: probably not a product detail page");
        product.openMainPicture();
        product.clickNextPicture(4);
        product.closeMainPicture();
        assertTrue(product.isMainPictureClosed(), "Big pic is not closed");
    }
}
