package framework;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {
    private static ReadFile rf;
    private static File xmlfilepath;

    public ReadFile() {
    }

    public static ReadFile getDriverInstance() throws IOException {
        if (rf == null) {
            rf = new ReadFile();
            xmlfilepath = new File("src/main/resources/configfiles/GlobalConfig.xml");
        }
        return rf;
    }

    private static Properties prop = new Properties();
    String keyvalue = "";
    String values = "";

    private FileInputStream readFile(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public String readProperty(File file, String key) throws IOException {
        if (file.exists()) {
            prop.load(readFile(file));
            values = prop.getProperty(key);
        }
        return values;
    }

    public String readXmlFile(String node, String key) throws ParserConfigurationException, IOException, SAXException {

        if (getDriverInstance().xmlfilepath.exists()) {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                NodeList nList = dBuilder.parse(xmlfilepath).getElementsByTagName(node);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        keyvalue = eElement.getElementsByTagName(key).item(0).getTextContent();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return keyvalue;
    }
}
