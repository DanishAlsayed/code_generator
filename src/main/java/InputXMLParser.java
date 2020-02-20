package main.java;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static main.java.CheckerUtils.checkString;

public class InputXMLParser extends InputParser {
    private final File xmlFile;

    public InputXMLParser(String xmlPath) {
        checkString(xmlPath, "xmlPath");
        xmlFile = new File(xmlPath);
    }

    public List<Class> inputClasses() {
        Document xmlDoc = null;
        try {
            xmlDoc = parseXML(xmlFile);
        } catch (Exception e) {
            System.out.println("Unable to parse xml input file: " + e.getMessage());
            e.printStackTrace();
        }

        assert xmlDoc != null;
        NodeList nodeList = xmlDoc.getElementsByTagName("class");
        List<Class> classes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String className = eElement.getAttribute("name");
                List<Attribute> attributes = extractAttributes(eElement.getElementsByTagName("attribute"));
                classes.add(new Class(className, attributes));
            }
        }
        return classes;
    }

    private List<Attribute> extractAttributes(NodeList variables) {
        List<Attribute> attributes = new ArrayList<>();
        for (int x = 0; x < variables.getLength(); x++) {
            attributes.add(new Attribute(
                    variables.item(x).getAttributes().item(0).getTextContent(),
                    inputToType(variables.item(x).getAttributes().item(1).getTextContent())));
        }
        return attributes;
    }

    private Document parseXML(File xmlFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        builder = factory.newDocumentBuilder();
        return builder.parse(xmlFile);
    }
}
