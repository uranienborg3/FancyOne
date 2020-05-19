package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage extends TopBase {

    private final By wishListButton = By.cssSelector(".lnk_wishlist a");

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
        private final By wishListNames = By.xpath("//tr[contains(@id, 'wishlist')]/td[1]/a");
        private final By wishListDeleteLink = By.xpath("//td[@class='wishlist_delete']/a");

        public WishListSubPage(WebDriver driver) {
            this.driver = driver;
        }

        public void createWishList(String name) {
            driver.findElement(nameField).sendKeys(name);
            driver.findElement(saveButton).click();
        }

        public boolean isWishlistPresent(String name) {
            return driver.findElements(wishListNames)
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

        public boolean hasWishListDisappeared(String name) {
            boolean wishListExists = false;
            List<WebElement> wishLists = driver.findElements(wishListNames);
            for (WebElement listName : wishLists) {
                if (listName.getText().equalsIgnoreCase(name)) {
                    wishListExists = isDisappeared(listName);
                    break;
                }
            }
            return wishListExists;
        }
    }
}