package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage extends TopBase {

    private By wishListButton = By.cssSelector(".lnk_wishlist a");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public WishListSubPage goWishLists() {
        driver.findElement(wishListButton).click();
        return new WishListSubPage(driver);
    }

    public class WishListSubPage {

        private WebDriver driver;
        private By nameField = By.id("name");
        private By saveButton = By.id("submitWishlist");
        private By wishLists = By.cssSelector("#block-history tr");
        private By wishListName = By.xpath("//td[1]/a");
        private By wishlistNames = By.xpath("//tr[contains(@id, \"wishlist\")]/td[1]/a");
        private By wishListDelete = By.xpath("//td[@class='wishlist_delete']/a");

        public WishListSubPage(WebDriver driver) {
            this.driver = driver;
        }

        public void createWishList(String name) {
            driver.findElement(nameField).sendKeys(name);
            driver.findElement(saveButton).click();
        }

        public boolean wishlistPresent(String name) {
            List<WebElement> links = driver.findElements(wishlistNames);
            boolean x = false;
            for (WebElement link : links) {
                if (link.getText().equalsIgnoreCase(name)) {
                    x = true;
                    break;
                }
            }
            return x;
        }

        public void deleteWishlist(String name) {
            List<WebElement> wishlists = driver.findElements(wishLists);
            for (WebElement list : wishlists) {
                if (list.findElement(wishListName).getText().equalsIgnoreCase("test")) {
                    list.findElement(wishListDelete).click();
                    break;
                }
            }
            driver.switchTo().alert().accept();
        }

        public boolean wishListDisappeared(String name) {
            return isDisappeared(wishLists);
        }
    }
}