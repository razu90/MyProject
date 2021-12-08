package automation_test.QA_Tek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class qaTek {
    WebDriver driver;
    @BeforeMethod
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
