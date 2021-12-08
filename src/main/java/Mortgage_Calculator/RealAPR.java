package Mortgage_Calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RealAPR {
//    Locator Info
    private final By HomePrice = By.name("HomeValue");
    private final By PaymentType = By.id("DownPaymentSel0");
    private final By DownPayment = By.name("DownPayment");
    private final By InterestRate = By.name("Interest");
    private final By YersOfLoan = By.name("Length");
    private final By DiscountPoint = By.name("Points");
    private final By LoanOriginationFees = By.name("Loan Origination Fees: ");
    private final By OtherClosingCosts = By.name("Closing");
    private final By ActualAPR = By.xpath("//*[@id=\"analysisDiv\"]/table[1]/tbody/tr[6]/td[1]/strong");
    private final By TotalClosingCosts = By.xpath("//*[@id=\"analysisDiv\"]/table[2]/tbody/tr[4]/td[1]/strong");

    WebDriver driver;
    Select select;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/calculators/what-is-the-real-apr-calculator.php");
        driver.manage().window().maximize();
    }
    @Test
    private void entarData() {
        driver.findElement(HomePrice).clear();
        driver.findElement(HomePrice).sendKeys("900000");

        driver.findElement(PaymentType).click();

        driver.findElement(DownPayment).clear();
        driver.findElement(DownPayment).sendKeys("200000");
    }
}
