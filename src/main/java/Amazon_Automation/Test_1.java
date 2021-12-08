package Amazon_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_1 {
    WebDriver driver;
    //Global Method

    @BeforeMethod
    public void browserOpen() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void VerifyHomePageTitle() {
        String expectedTitle = "Best Buy | Official Online Store | Shop Now & Save";
        String actualTile = driver.getTitle();
        Assert.assertEquals(actualTile, expectedTitle);
    }
    @AfterMethod
    public void browserClose() {
        driver.quit();

    }
}

//        driver.findElement(By.id("signInSubmit")).click();
//        driver.get("https://www.macys.com/account/signin");
//       driver.findElement(By.id("email")).sendKeys("");
//       driver.findElement(By.id("pw-input")).sendKeys("");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));