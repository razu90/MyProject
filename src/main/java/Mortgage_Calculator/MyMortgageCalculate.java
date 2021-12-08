package Mortgage_Calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyMortgageCalculate {
//    Locator info as a variable
    private final By InputHomeValue = By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By SelectPaymentType = By.name("param[downpayment_type]");
    private final By AmountOfLoan = By.id("loanamt");
    private final By APR = By.id("intrstsrate");
    private final By YearsOfLoan = By.id("loanterm");
    private final By StartMonth = By.name("param[start_month]");
    private final By StartYear = By.id("start_year");
    private final By TAX = By.id("pptytax");
    private final By PMI = By.id("pmi");
    private final By HomeIns = By.id("hoi");
    private final By HOA = By.id("hoa");
    private final By LoanType = (By.name("param[milserve]"));
    private final By BuyOrRefi = (By.name("param[refiorbuy]"));

    WebDriver driver;
    Select select;
//    Before Method
    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }
// Data Entry Method
    private void enterData() {

        driver.findElement(InputHomeValue).clear();
        // Enter Home Value "900000"
        driver.findElement(InputHomeValue).sendKeys("900000");

        driver.findElement(DownPayment).clear();
        // Enter down payment "200000"
        driver.findElement(DownPayment).sendKeys("200000");
// click on the radio button $
        driver.findElement(SelectPaymentType).click();

        driver.findElement(AmountOfLoan).clear();
// Enter loan amount "700000"
        driver.findElement(AmountOfLoan).sendKeys("700000");

        driver.findElement(APR).clear();
        // Enter interest rate "3.5%"
        driver.findElement(APR).sendKeys("3.5");

        driver.findElement(YearsOfLoan).clear();
// Enter Loan term 30 years
        driver.findElement(YearsOfLoan).sendKeys("30");
// Select the start date month "Mar"
        select = new Select(driver.findElement(StartMonth));
        select.selectByVisibleText("Mar");

        driver.findElement(StartYear).clear();
// Enter the year "2022"
        driver.findElement(StartYear).sendKeys("2022");

        driver.findElement(TAX).clear();
// Enter Property Tax "10000"
        driver.findElement(TAX).sendKeys("10000");

        driver.findElement(PMI).clear();
// Enter PMI "0.5"
        driver.findElement(PMI).sendKeys("0.5");

        driver.findElement(HomeIns).clear();
// Enter Home Ins "1000"
        driver.findElement(HomeIns).sendKeys("1000");

        driver.findElement(HOA).clear();
// Enter monthly hoa "500"
        driver.findElement(HOA).sendKeys("500");
// Select loan type "FHA"
        select = new Select(driver.findElement(LoanType));
        select.selectByVisibleText("FHA");
// Select "Buy" option
        select = new Select(driver.findElement(BuyOrRefi));
        select.selectByVisibleText("Buy");

    }

    @Test (invocationCount = 1)
    public void calculateRate() {
        enterData();
        // Click on the Calculate Button
        driver.findElement(By.name("cal")).click();
        String expectedTotalMonthlyPayment = "4,559.98";
        String formattedXpath = String.format("//h3[text()='$%s']", expectedTotalMonthlyPayment);
        boolean present = driver.findElement(By.xpath(formattedXpath)).isDisplayed();
// Validate that the total monthly payment is $4,559.98
        Assert.assertTrue(present, "Total Monthly Payment is not presented");
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}

