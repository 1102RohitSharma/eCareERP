package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class BasePage{
    public WebElement getElement (File file, String element, int time) throws Exception {
        String value = ReadFile.getDriverInstance().readProperty ( file, element );
        String locator = ReadFile.getDriverInstance().readProperty ( file, element + "_type" );
        WebElement webelement = null;
        WebDriverWait wait = new WebDriverWait ( AppDriver.getDriverInstance().getDriver(), time );
        switch (locator) {
            case "id":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.id ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElement ( By.id ( value ) );
                break;
            case "xpath":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.xpath ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElement ( By.xpath ( value ) );
                break;
            case "name":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.name ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElement ( By.name ( value ) );
                break;
            case "linktext":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.linkText ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElement ( By.linkText ( value ) );
                break;
            case "tagname":
//                wait.wait ( time );
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.tagName ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElement ( By.tagName ( value ) );
                break;
            case "cssselector":
//                wait.wait ( time );
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.cssSelector ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElement ( By.cssSelector ( value ) );
                break;
            case "classname":
                //              wait.wait ( time );
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.className ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElement ( By.className ( value ) );
                break;
        }
        return webelement;
    }

    public List<WebElement> getElements (File file, String element, int time) throws IOException, ParserConfigurationException, SAXException {
        String value = ReadFile.getDriverInstance().readProperty( file, element );
        String locator = ReadFile.getDriverInstance().readProperty ( file, element + "_type" );
        List <WebElement> webelement = null;
        WebDriverWait wait = new WebDriverWait ( AppDriver.getDriverInstance().getDriver(), time );
        switch (locator) {
            case "id":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.id ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElements ( By.id ( value ) );
                break;
            case "xpath":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.xpath ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElements ( By.xpath ( value ) );
                break;
            case "name":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.name ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElements ( By.name ( value ) );
                break;
            case "linktext":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.linkText ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElements ( By.linkText ( value ) );
                break;
            case "tagname":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.tagName ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElements ( By.tagName ( value ) );
                break;
            case "cssselector":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.cssSelector ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElements ( By.cssSelector ( value ) );
                break;
            case "classname":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.className ( value ) ) );
                webelement = AppDriver.getDriverInstance().getDriver ( ).findElements ( By.className ( value ) );
                break;

        }

        return webelement;
        //test push command from git bash
    }

}
