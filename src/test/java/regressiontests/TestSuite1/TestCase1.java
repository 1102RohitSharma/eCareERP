package regressiontests.TestSuite1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import regressiontests.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestCase1 extends BaseTest{
    @Test
    public void a() throws ParserConfigurationException, SAXException, IOException {
        getDriverInstance().getDriver().findElement(By.id("txtUserName")).sendKeys("admin");
        getDriverInstance().getDriver().findElement(By.id("txtPassword")).sendKeys("admin@123");
        getDriverInstance().getDriver().findElement(By.id("btnLogin")).click();

    }
}