package automation_test.QA_Tek;

import automation_test.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class qaTek extends BaseClass {
    @BeforeMethod
    public void OpenBrowser() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://qateksolutions-lms.com/all-courses");
    }
    @Test
    public void InputData() {
        String expectedTitle = "QA Tek LMS";
        String actualTitle = driver.getTitle();
        driver.findElement(By.xpath("//a[2][text() ='Login']")).click();
        driver.findElement(By.id("outlined-basic")).sendKeys("RAZU");
        driver.findElement(By.id("outlined-password-input")).sendKeys("Fahima1992");
        driver.findElement(By.xpath("//span[1][text() ='Login']")).click();
        driver.findElement(By.cssSelector("#root > div:nth-child(2) > header > div > div > a.jss7.active")).click();

    }
}
