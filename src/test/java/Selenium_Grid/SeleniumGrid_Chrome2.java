package Selenium_Grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;



public class SeleniumGrid_Chrome2 {
    @Test
    public void executeInDocker(){
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
