package automation_test.Mortgage_Calculator;

import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class MyMortgageCalculate extends BaseClass {


    @Test(invocationCount = 1)
    public void calculateRate() {
        new NavigationBar(driver)
                .navigateToHome()
                .enterHomePrice("900000")
                .enterDownPayment("200000")
                .selectDownPaymentInDollar()
                .enterAmountOfLoan("700000")
                .enterApr("3.5")
                .enterYearsOfLoan("30")
                .selectMonth("Mar")
                .selectYear("2022")
                .enterPropertyTax("10000")
                .enterPmi("0.5")
                .enterHomeInsurance("1000")
                .enterHoa("500")
                .selectLoanType("FHA")
                .selectBuyOrRefOption("Buy")
                .clickCalculator()
                .validateTotalMonthlyPayment("4,559.98");

    }

}