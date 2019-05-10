package regressiontests;

import framework.AppDriver;
import framework.LaunchBrowser;
import framework.ReadFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BaseTest{

    private void getURL() throws IOException, SAXException, ParserConfigurationException {
        AppDriver.getDriverInstance().getDriver().get(new ReadFile().readXmlFile("configuration", "desired_url"));
    }

    @BeforeSuite
    public void beforeSuite() throws IOException, SAXException, ParserConfigurationException {
        getURL();
    }

    @AfterSuite
    public void afterSuite() {
        try {
            if (null != AppDriver.getDriverInstance().getDriver()) {
                AppDriver.getDriverInstance().getDriver().close();
                AppDriver.getDriverInstance().getDriver().quit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}

