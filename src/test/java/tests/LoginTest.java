package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://agrimart-demo.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.setUsername("farmer123");
        loginPage.setPassword("password123");
        loginPage.clickLogin();

        String expectedUrl = "https://agrimart-demo.com/home";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}