package acoeLogics;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlDataFetch {
public static void main(String[] args) {
	 String keyToFetch = "FirstName";
     String xmlFilePath = "C:\\Users\\Chandan\\Desktop\\RmgYantra_HRM.xml";

     try {
    	 
         File xmlFile = new File(xmlFilePath);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(xmlFile);
         doc.getDocumentElement().normalize();

         NodeList nodeList = doc.getElementsByTagName("entry");

         for (int temp = 0; temp < nodeList.getLength(); temp++) {
             Node node = nodeList.item(temp);

             if (node.getNodeType() == Node.ELEMENT_NODE) {
                 Element entryElement = (Element) node;
                 String key = entryElement.getElementsByTagName("key").item(0).getTextContent();
                 String value = entryElement.getElementsByTagName("value").item(0).getTextContent();

                 if (key.equals(keyToFetch)) {
                     System.out.println("Key: " + key + ", Value: " + value);
                     // You can return or use the 'value' as needed
                     break;
                 }
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
}
}
