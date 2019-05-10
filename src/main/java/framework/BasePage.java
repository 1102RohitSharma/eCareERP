package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import regressiontests.*;
public class BasePage extends BaseTest{
    BaseTest
    public WebElement getElement (File file, String element, int time) throws Exception {
        String value = readProperty ( file, element );
        String locator = readProperty ( file, element + "_type" );
        WebElement webelement = null;
        WebDriverWait wait = new WebDriverWait ( driver, time );
        switch (locator) {
            case "id":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.id ( value ) ) );
                webelement = getCurrentDriver ( ).findElement ( By.id ( value ) );
                break;
            case "xpath":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.xpath ( value ) ) );
                webelement = getCurrentDriver ( ).findElement ( By.xpath ( value ) );
                break;
            case "name":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.name ( value ) ) );
                webelement = getCurrentDriver ( ).findElement ( By.name ( value ) );
                break;
            case "linktext":
//                this.wait ();
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.linkText ( value ) ) );
                webelement = getCurrentDriver ( ).findElement ( By.linkText ( value ) );
                break;
            case "tagname":
//                wait.wait ( time );
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.tagName ( value ) ) );
                webelement = getCurrentDriver ( ).findElement ( By.tagName ( value ) );
                break;
            case "cssselector":
//                wait.wait ( time );
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.cssSelector ( value ) ) );
                webelement = getCurrentDriver ( ).findElement ( By.cssSelector ( value ) );
                break;
            case "classname":
                //              wait.wait ( time );
//                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.className ( value ) ) );
                webelement = getCurrentDriver ( ).findElement ( By.className ( value ) );
                break;
        }
        return webelement;
    }

    public List<WebElement> getElements (File file, String element, int time) throws IOException {
        String value = readProperty ( file, element );
        String locator = readProperty ( file, element + "_type" );
        List <WebElement> webelement = null;
        WebDriverWait wait = new WebDriverWait ( driver, time );
        switch (locator) {
            case "id":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.id ( value ) ) );
                webelement = getCurrentDriver ( ).findElements ( By.id ( value ) );
                break;
            case "xpath":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.xpath ( value ) ) );
                webelement = getCurrentDriver ( ).findElements ( By.xpath ( value ) );
                break;
            case "name":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.name ( value ) ) );
                webelement = getCurrentDriver ( ).findElements ( By.name ( value ) );
                break;
            case "linktext":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.linkText ( value ) ) );
                webelement = getCurrentDriver ( ).findElements ( By.linkText ( value ) );
                break;
            case "tagname":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.tagName ( value ) ) );
                webelement = getCurrentDriver ( ).findElements ( By.tagName ( value ) );
                break;
            case "cssselector":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.cssSelector ( value ) ) );
                webelement = getCurrentDriver ( ).findElements ( By.cssSelector ( value ) );
                break;
            case "classname":
                wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( By.className ( value ) ) );
                webelement = getCurrentDriver ( ).findElements ( By.className ( value ) );
                break;
        }

        return webelement;
        //test push command from git bash
    }

}
