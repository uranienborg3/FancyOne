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
        private By wishListRows = By.cssSelector("#block-history tr");
        private By wishListNameLink = By.xpath("//td[1]/a");
        private By wishlistNames = By.xpath("//tr[contains(@id, 'wishlist')]/td[1]/a");
        private By wishListDeleteLink = By.xpath("//td[@class='wishlist_delete']/a");

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
            List<WebElement> wishlists = driver.findElements(wishListRows);
            for (WebElement list : wishlists) {
                if (list.findElement(wishListNameLink).getText().equalsIgnoreCase(name)) {
                    list.findElement(wishListDeleteLink).click();
                    break;
                }
            }
            driver.switchTo().alert().accept();
        }

        public boolean wishListDisappeared(String name) {
            boolean x = false;
            List<WebElement> wishlists = driver.findElements(wishlistNames);
            for (WebElement listName : wishlists) {
                if (listName.getText().equalsIgnoreCase(name)) {
                    x = isDisappeared(listName);
                    break;
                }
            }
            return x;
        }
    }
}