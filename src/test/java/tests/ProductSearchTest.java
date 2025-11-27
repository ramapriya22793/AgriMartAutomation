package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductSearchTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://agrimart-demo.com/home");
        homePage = new HomePage(driver);
    }

    @Test
    public void searchProductTest() {
        homePage.searchProduct("Rice Seeds");
        String expectedTitle = "Rice Seeds - AgriMart";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}