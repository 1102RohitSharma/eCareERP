package regressiontests.TestSuite1;

import framework.AppDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import regressiontests.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestCase1 extends BaseTest{
    @Test
    public void a() throws ParserConfigurationException, SAXException, IOException {
        AppDriver.getDriverInstance().getDriver().findElement(By.id("txtUserName")).sendKeys("admin");
        AppDriver.getDriverInstance().getDriver().findElement(By.id("txtPassword")).sendKeys("admin@123");
        AppDriver.getDriverInstance().getDriver().findElement(By.id("btnLogin")).click();

    }
}