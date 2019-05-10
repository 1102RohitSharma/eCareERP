package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

class BrowserNotDefinedException extends Exception {
}

public class LaunchBrowser {
    WebDriver dr;

    public WebDriver getCurrentBrowser(String browsername) throws IOException, SAXException, ParserConfigurationException {
        String br = browsername.toLowerCase();
        try {
            switch (br) {
                case "chrome":
                    String chromedriverpathe = new ReadFile().readXmlFile("Location", "ChromeDriverPath");
                    System.setProperty("webdriver.chrome.driver", chromedriverpathe);
                    dr = new ChromeDriver();
                    break;
                case "firefox":
                    String firefoxdriverpath = new ReadFile().readXmlFile("Location", "FirefoxDriverPath");
                    System.setProperty("webdriver.gecko.driver", firefoxdriverpath);
                    dr = new FirefoxDriver();
                    break;
                case "ie":
                    String iedriverpath = new ReadFile().readXmlFile("Location", "IeDriverPath");
                    System.setProperty("webdriver.ie.driver", iedriverpath);
                    dr = new InternetExplorerDriver();
                    break;
                case "edge":
                    String edgedriverpath = new ReadFile().readXmlFile("Location", "EdgeDriverPath");
                    System.setProperty("webdriver.edge.driver", edgedriverpath);
                    dr = new EdgeDriver();
                    break;
                case "opera":
                    String operadriverpath = new ReadFile().readXmlFile("Location", "OperaDriverPath");
                    System.setProperty("webdriver.opera.driver", operadriverpath);
                    dr = new OperaDriver();
                    break;
                default:
                    throw new BrowserNotDefinedException();

            }
        } catch (BrowserNotDefinedException bx) {
            System.out.println("Unknown browser found. Use chrome in case of Google Chrome, firefox in case of Mozilla Firefox, ie in case of Internet Explorer, edge in case of Microsoft Edge and opera in case of Opera browser. In case of any other browser contact admin");
        }
        return dr;
    }
}
