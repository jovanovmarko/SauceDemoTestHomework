package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getUsernameField (){
        return getDriver().findElement(userNameField);
    }

    public WebElement getPasswordField (){
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginButton (){
        return getDriver().findElement(loginButton);
    }

    public void login (String username, String password){
        getUsernameField().clear();
        getPasswordField().clear();
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
}
