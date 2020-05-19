package page.account;

import element.AbstractElement;
import navigation.Navigable;
import navigation.TopNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends AbstractElement implements Navigable {

    private final By wishListButton = By.cssSelector(".lnk_wishlist a");
    private final TopNavigation navigation;

    public AccountPage(WebDriver driver) {
        super(driver);
        navigation = new TopNavigation(driver);
    }

    public WishListPage goToWishLists() {
        driver.findElement(wishListButton).click();
        return new WishListPage(driver);
    }

    @Override
    public TopNavigation provideNavigation() {
        return navigation;
    }
}