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
import utilities.ReadConfigFiles;
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyMortgageCalculateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(MyMortgageCalculateParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("---------------Test Name:My Mortgage Calculat---------------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        Action.browserActions(driver).openBrowser(browserUrl);

    }

    @Test (invocationCount = 1)
    public void calculateRate(){

        try {
            ResultSet resultSet = SqlConnector.readData("select * from MyMortgageCalculate");
            while (resultSet.next()) {
                new NavigationBar(driver)
                        .navigateToHome()
                        .enterHomePrice(resultSet.getString("inputhomevalue"))
                        .enterDownPayment(resultSet.getString("downpayment"))
                        .selectDownPaymentInDollar()
                        .enterAmountOfLoan(resultSet.getString("amountofloan"))
                        .enterApr(resultSet.getString("apr"))
                        .enterYearsOfLoan(resultSet.getString("yearsofloan"))
                        .selectMonth("Mar")
                        .selectYear("2022")
                        .enterPropertyTax(resultSet.getString("tax"))
                        .enterPmi(resultSet.getString("pmi"))
                        .enterHomeInsurance(resultSet.getString("homeins"))
                        .enterHoa(resultSet.getString("hoa"))
                        .selectLoanType(resultSet.getString("loantype"))
                        .selectBuyOrRefOption(resultSet.getString("buyorrefi"))
                        .clickCalculator()
                        .validateTotalMonthlyPayment(resultSet.getString("calculator"));
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @AfterMethod
    public void closeBrowser() {
        LOGGER.info("------End Test Case------");
        Action.browserActions(driver).closeBrowser();
    }
}
