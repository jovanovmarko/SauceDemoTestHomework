package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutSecondPage extends BasePage{

    private By finishButton = By.id("finish");

    private By totalAmount = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");

    public CheckOutSecondPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFinishButton (){
        return getDriver().findElement(finishButton);
    }

    public WebElement getTotalAmount (){
        return getDriver().findElement(totalAmount);
    }

    public void finishCheckout (){
        getFinishButton().click();
    }


}
