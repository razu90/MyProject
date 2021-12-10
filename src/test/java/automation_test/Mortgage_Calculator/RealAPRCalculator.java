package automation_test.Mortgage_Calculator;
import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.NavigationBar;


public class RealAPRCalculator extends BaseClass {



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

}
