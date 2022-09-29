package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private By addedItemName = By.xpath("//*[@id=\"item_4_title_link\"]/div");

    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAddedItemName() {
        return getDriver().findElement(addedItemName);
    }

    public WebElement getCheckoutButton() {
        return getDriver().findElement(checkoutButton);
    }

    public void checkout() {
        getCheckoutButton().click();
    }
}
