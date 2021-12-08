package paramteres;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue(){
        return new Object[][] {
                {"Razu"},
                {"Asif"},
                {"Parvez"}
        };

    }

    @DataProvider(name = "RealAprCal")
    public Object[][] storeRealAprRates() {
        return new Object[][]{
                {"900000", "200000", "3.5", "3.595%"}
        };
    }

    @DataProvider(name = "MultipleValues")
    public Object[][] storeMultipleValues() {
        return new Object[][] {
                {"Razu", "New York", 11208},
                {"Asif", "New York", 11432},
                {"Parvez", "philadelphia", 19019}
        };
    }

    @Test(dataProvider = "SingleValue")
    public void readSingleValue(String name) {
        System.out.println("[Single Column Value] Name is: " + name);
    }

    @Test(dataProvider = "MultipleValues")
    public void readMultipleValues(String name, String state, int zipCode) {
        System.out.println("[Multiple Column Value] Name is: " + name);
        System.out.println("[Multiple Column Value] State is: " + state);
        System.out.println("[Multiple Column Value] Zip Code is: " + zipCode);
    }
}

 //Video 3 time 25 LectureNote Week:11 Page:13