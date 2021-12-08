package automation_test.Testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ReadConfigFiles;

public class TestNgMavenExample {
    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenExample.class);



@Test
    public void run() {
        LOGGER.debug("This is debug message");
        LOGGER.info("This is info message");
        LOGGER.warn("This is a warning");
        LOGGER.error("This is an error");
        LOGGER.fatal("This is dangerous");
    }

    @Test
    public void testPropertyFile() {
        LOGGER.info(ReadConfigFiles.getPropertyValues("DbUser"));
    }

}
