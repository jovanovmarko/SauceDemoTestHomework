package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {


    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");

    private By removeItemButton = By.id("remove-sauce-labs-backpack");

    private By cart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    private By shoppingCartInfoBadge = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    private By addedItemName = By.xpath("//*[@id=\"item_4_title_link\"]/div");


    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAddToCartButton() {
        return getDriver().findElement(addToCartButton);
    }

    public WebElement getCart() {
        return getDriver().findElement(cart);
    }

    public WebElement getShoppingCartInfoBadge() {
        return getDriver().findElement(shoppingCartInfoBadge);
    }


    public WebElement getAddedItemName() {
        return getDriver().findElement(addedItemName);
    }

    public WebElement getRemoveItemButtom() {
        return getDriver().findElement(removeItemButton);
    }

    public void addToCart() {
        getAddToCartButton().click();
    }

    public void removeItemFromCart() {
        getRemoveItemButtom().click();
    }

    public void checkCart() {
        getCart().click();
    }


}
