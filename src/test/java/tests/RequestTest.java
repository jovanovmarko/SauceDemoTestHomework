package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;


public class RequestTest {
    private LoginPage loginPage;

    private InventoryPage inventoryPage;

    private CartPage cartPage;

    private CheckOutFirstPage checkOutFirstPage;

    private CheckOutSecondPage checkOutSecondPage;

    private CheckOutFinalPage checkOutFinalPage;
    private WebDriver driver;

    private WebDriverWait driverWait;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, driverWait);
        inventoryPage = new InventoryPage(driver, driverWait);
        cartPage = new CartPage(driver, driverWait);
        checkOutFirstPage = new CheckOutFirstPage(driver, driverWait);
        checkOutSecondPage = new CheckOutSecondPage(driver, driverWait);
        checkOutFinalPage = new CheckOutFinalPage(driver, driverWait);

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com");
    }


    @Test
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");
        String expectedResult = "PRODUCTS";
        WebElement productsInventoryText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        productsInventoryText.getText();
        String actualResult = productsInventoryText.getText();
        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test
    public void testAddToCartBadgeDisplay() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        Assert.assertTrue(inventoryPage.getShoppingCartInfoBadge().isDisplayed());

    }

    @Test
    public void testAddedItemToCart() {
        String expectedResult = "Sauce Labs Backpack";
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.removeItemFromCart();
        inventoryPage.addToCart();
        inventoryPage.checkCart();
        String actualResult = cartPage.getAddedItemName().getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testTotalAmount() {
        String expectedResult = "32.39";
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        inventoryPage.checkCart();
        cartPage.checkout();
        checkOutFirstPage.checkout();
        String actualResult = checkOutSecondPage.getTotalAmount().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void testCheckOutConfirmationMessage() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.checkCart();
        cartPage.checkout();
        checkOutFirstPage.checkout();
        checkOutSecondPage.finishCheckout();
        Assert.assertTrue(checkOutFinalPage.getCheckOutFinalPage().isDisplayed());

    }

    @Test
    public void logOutTest() {
        loginPage.login("standard_user", "secret_sauce");
        WebElement burgerBtn = driver.findElement(By.id("react-burger-menu-btn"));
        burgerBtn.click();
        WebElement logOutBtn = driver.findElement(By.id("logout_sidebar_link"));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logOutBtn.click();
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertTrue(errorMsg.isDisplayed());


    }
}
