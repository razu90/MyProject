package automation_test;

import command_providers.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;
import utilities.ReadConfigFiles;

public class BaseClass {
    public WebDriver driver;
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    String tesstCaseName = String.format("-----------Test: %s-----------------", this,getClass().getName());
    String endTesstCase = String.format("-----------Test End: %s-----------------", this,getClass().getName());

    @BeforeClass
    public void addThread() {
        ThreadContext.put("threadName", this.getClass().getName());
        driver = DriverFactory.getInstance().getDriver();
    }

    @BeforeMethod
    public void browserInitialization() {
        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        LOGGER.info(tesstCaseName);
        LOGGER.debug("Opening the URL: "+ browserUrl);
        Action.browserActions(driver).openBrowser(browserUrl);
    }

    @AfterMethod
    public void closeBrowser() {
        DriverFactory.getInstance().removeDriver();
        LOGGER.info(endTesstCase);
    }
}
