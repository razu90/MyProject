package automation_test.Mortgage_Calculator;
import command_providers.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;


public class RealAPRCalculator {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        Action.browserActions(driver).openBrowser("https://www.mortgagecalculator.org/");
    }


    @Test
    public void CalculateRealAPR() {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .WaitForPage()
                .enterHomePrice("900000")
                .selectPaymentType()
                .enterDownPayment("200000")
                .enterInterestRate("3.5")
                .clickCalculatorButton()
                .validateRealApr("3.595%");
    }

    @AfterMethod
    public void closeBrowser() {
        Action.browserActions(driver).closeBrowser();
    }
}
