package framework;

import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AppDriver {
    private static WebDriver driver;
    private static AppDriver ad;

    public static AppDriver getDriverInstance() throws IOException {
        if (ad == null) {
            ad =new AppDriver();
        }
        return ad;
    }

    public WebDriver getDriver() throws IOException, SAXException, ParserConfigurationException {
        if (driver == null) {
            driver = new LaunchBrowser().getCurrentBrowser(new ReadFile().readXmlFile("configuration", "default_browser"));
        }
        return driver;
    }

}
