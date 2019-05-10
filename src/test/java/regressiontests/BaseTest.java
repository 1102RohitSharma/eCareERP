package regressiontests;

import framework.LaunchBrowser;
import framework.ReadFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BaseTest {
    private static WebDriver driver;
    private static BaseTest bt;

    public static BaseTest getDriverInstance() throws IOException {
        if (bt == null) {
            bt = new BaseTest();
        }
        Integer Student[] =  new Integer[100];
        return bt;

    }

    public WebDriver getDriver() throws IOException, SAXException, ParserConfigurationException {
        if (driver == null) {
            beforeSuite();
        }
        return driver;
    }

    private void getURL() throws IOException, SAXException, ParserConfigurationException {
        driver.get(new ReadFile().readXmlFile("configuration", "desired_url"));
    }

    @BeforeSuite
    public void beforeSuite() throws IOException, SAXException, ParserConfigurationException {
        driver = new LaunchBrowser().getCurrentBrowser(new ReadFile().readXmlFile("configuration", "default_browser"));
        getURL();
    }

    @AfterSuite
    public void afterSuite() {
        if (null != driver) {
//            driver.close();
//            driver.quit();
        }
    }
}

