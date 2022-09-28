package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutFinalPage extends BasePage {
    private By checkOutComplete = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public CheckOutFinalPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getCheckOutFinalPage (){
        return getDriver().findElement(checkOutComplete);
    }




}
