package Amazon_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Amazon_Test {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }

    @Test(invocationCount = 1)
    public void VerifyHomePageTitle() throws InterruptedException {
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTile = driver.getTitle();
        Assert.assertEquals(actualTile, expectedTitle);
//  MOUSE HOVER
        Actions MouseHover = new Actions(driver);
        WebElement HelloSignin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        MouseHover.moveToElement(HelloSignin).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.className("nav-action-inner")).click();
        driver.findElement(By.id("ap_email")).sendKeys("fr.mahi@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("fahima1992");
//  Checkbox
        WebElement Checkbox = driver.findElement(By.name("rememberMe"));
        Checkbox.click();
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Haleem");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[7]/div/span/div/div/div[2]/div[1]/h2/a")).click();
        driver.findElement(By.className("a-dropdown-prompt")).click();
        driver.findElement(By.id("quantity_11")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("hlb-view-cart-announce")).click();


    }



}
