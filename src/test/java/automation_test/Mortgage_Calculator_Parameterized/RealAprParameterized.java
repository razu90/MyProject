package automation_test.Mortgage_Calculator_Parameterized;

import command_providers.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import paramteres.DataProviderClass;
import utilities.ReadConfigFiles;

public class RealAprParameterized {
    private static final Logger LOGGER = LogManager.getLogger(RealAprParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("---------------Test Name:My Mortgage Calculat---------------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        Action.browserActions(driver).openBrowser(browserUrl);
    }

    @Test(dataProvider = "RealAprCal", dataProviderClass = DataProviderClass.class)
    public void realApr(String homePrice, String downPayment, String interestRate, String actualApr) {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .WaitForPage()
                .enterHomePrice(homePrice)
                .selectPaymentType()
                .enterDownPayment(downPayment)
                .enterInterestRate(interestRate)
                .clickCalculatorButton()
                .validateRealApr(actualApr);
    }
    @AfterMethod
    public void closeBrowser() {
        LOGGER.info("------End Test Case------");
        Action.browserActions(driver).closeBrowser();
    }
}
