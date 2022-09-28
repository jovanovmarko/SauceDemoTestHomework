package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutFirstPage extends BasePage {

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");

    private By continueBtn = By.id("continue");

    public CheckOutFirstPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public WebElement getFirstName (){
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName (){
        return getDriver().findElement(lastName);
    }

    public WebElement getZipCode (){
        return getDriver().findElement(zipCode);
    }

    public WebElement getContinueButton (){
        return getDriver().findElement(continueBtn);
    }

    public void checkout (){
        getFirstName().clear();
        getLastName().clear();
        getZipCode().clear();
        getFirstName().sendKeys("John");
        getLastName().sendKeys("Doe");
        getZipCode().sendKeys("12345");
        getContinueButton().click();


    }
}
