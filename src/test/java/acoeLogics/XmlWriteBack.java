package acoeLogics;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlWriteBack {
    public static void main(String[] args) {
        String keyToFetch = "TestCaeDescription";
        String newValue = "UpdatedValue";

        try (InputStream inputStream = new FileInputStream("C:\\Users\\Chandan\\Desktop\\RmgYantra_HRM.xml")) {
            // Read the XML content into a ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // Parse the XML content
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new ByteArrayInputStream(baos.toByteArray()));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("entry");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element entryElement = (Element) node;
                    String key = entryElement.getElementsByTagName("key").item(0).getTextContent();

                    if (key.equals(keyToFetch)) {
                        // Update the value
                        entryElement.getElementsByTagName("value").item(0).setTextContent(newValue);

                        // Get the updated XML data in string format
                        String updatedXmlString = convertDocumentToString(doc);
                        System.out.println("Updated XML data:\n" + updatedXmlString);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String convertDocumentToString(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
