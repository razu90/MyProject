package automation_test.Mortgage_Calculator;

import command_providers.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RealAPR {
//    Locator Info
    private final By RateLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By Calculator = By.xpath("//label[text()='Calculator']");
    private final By HomePrice = By.name("HomeValue");
    private final By PaymentType = By.id("DownPaymentSel0");
    private final By DownPayment = By.name("DownPayment");
    private final By InterestRate = By.name("Interest");
    private final By YersOfLoan = By.name("Length");
    private final By DiscountPoint = By.name("Points");
    private final By LoanOriginationFees = By.name("Loan Origination Fees: ");
    private final By OtherClosingCosts = By.name("Closing");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAPR = By.xpath("//*[@id=\"analysisDiv\"]/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    WebDriver driver;
    Select select;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        Action.browserActions(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
    public void navigateToRealAPR() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(RateLink)).perform();


        driver.findElement(RealAprLink).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Calculator));

    }

        public void enterData() {
//        driver.findElement(HomePrice).clear();
//        driver.findElement(HomePrice).sendKeys("900000");
        Action.element(driver, HomePrice).setValue("900000");
//        driver.findElement(PaymentType).click();
        Action.element(driver,PaymentType).click();
//        driver.findElement(DownPayment).clear();
//        driver.findElement(DownPayment).sendKeys("200000");
        Action.element(driver, DownPayment).setValue("200000");
//        driver.findElement(InterestRate).clear();
//        driver.findElement(InterestRate).sendKeys("3.5");
        Action.element(driver,InterestRate).setValue("3.5");
    }

    @Test
    public void CalculateRealAPR() {
        navigateToRealAPR();
        enterData();
//        driver.findElement(CalculateButton).click();
        Action.element(driver,CalculateButton).click();
        String actualRealAprRate = driver.findElement(ActualAPR).getText();
        Assert.assertEquals(actualRealAprRate,"3.595%");
    }
    @AfterMethod
    public void closeBrowser() {
        Action.browserActions(driver).closeBrowser();
    }
}
