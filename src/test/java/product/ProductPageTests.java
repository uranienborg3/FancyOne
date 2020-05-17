package product;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductPageTests extends BaseTests {
    @Test
    public void testViewPictureInLarge() {
        var product = topbase.switchToHomePage().viewProductDetails(3);
        assertTrue(product.bigPicIsDisplayed(), "Big pic is not there: probably not a product detail page");
        product.clickBigPic();
        product.closeBigPic();
        assertTrue(product.bigPicIsClosed(), "Big pic is not closed");
    }

    @Test
    public void testClickNextPic() {
        var product = topbase.switchToHomePage().viewProductDetails(3);
        assertTrue(product.bigPicIsDisplayed(), "Big pic is not there: probably not a product detail page");
        product.clickBigPic();
        product.clickNextBigPic(4);
        product.closeBigPic();
        product.bigPicIsClosed();
    }
}
