package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage extends TopBase {

    // TODO: fields, that will not change, must be final.
    private By wishListButton = By.cssSelector(".lnk_wishlist a");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public WishListSubPage goWishLists() {
        driver.findElement(wishListButton).click();
        return new WishListSubPage(driver);
    }

    public class WishListSubPage {

        private final WebDriver driver;
        private final By nameField = By.id("name");
        private final By saveButton = By.id("submitWishlist");
        private final By wishListRows = By.cssSelector("#block-history tr");
        private final By wishListNameLink = By.xpath("//td[1]/a");
        private final By wishlistNames = By.xpath("//tr[contains(@id, 'wishlist')]/td[1]/a");
        private final By wishListDeleteLink = By.xpath("//td[@class='wishlist_delete']/a");

        public WishListSubPage(WebDriver driver) {
            this.driver = driver;
        }

        public void createWishList(String name) {
            driver.findElement(nameField).sendKeys(name);
            driver.findElement(saveButton).click();
        }

        public boolean wishlistPresent(String name) {
            List<WebElement> links = driver.findElements(wishlistNames);
            // TODO: rename variable (https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
            /* for example, "x" could be renamed to "isLinkTheSame" ot something like that */
            boolean x = false;
            for (WebElement link : links) {
                if (link.getText().equalsIgnoreCase(name)) {
                    x = true;
                    break;
                }
            }
            return x;
        }

        // TODO: variables and methods, which returns boolean, must started with "is".
        public boolean isWishlistPresent(String name) {
            // TODO: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
            return driver.findElements(wishlistNames)
                    .stream()
                    .anyMatch(link -> link.getText().equalsIgnoreCase(name));
        }

        public void deleteWishlist(String name) {
            List<WebElement> wishLists = driver.findElements(wishListRows);
            for (WebElement list : wishLists) {
                if (list.findElement(wishListNameLink).getText().equalsIgnoreCase(name)) {
                    list.findElement(wishListDeleteLink).click();
                    break;
                }
            }
            driver.switchTo().alert().accept();
        }

        public boolean wishListDisappeared(String name) {
            boolean x = false;
            List<WebElement> wishLists = driver.findElements(wishlistNames);
            for (WebElement listName : wishLists) {
                if (listName.getText().equalsIgnoreCase(name)) {
                    x = isDisappeared(listName);
                    break;
                }
            }
            return x;
        }
    }
}