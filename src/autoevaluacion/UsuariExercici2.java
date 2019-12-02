package autoevaluacion;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class UsuariExercici2 {

    public static  Document createDoc() throws ParserConfigurationException, IOException, SAXException {
        Document document = null;
        try{
            File inputFIle = new File("/home/dam2a/Documents/accesadades/autoevaluacio/cartaplats.xml");
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFIle);
            document.getDocumentElement().normalize();
        }catch (Exception e){
            e.printStackTrace();
        }
        return document;
    }

    public static void addElements(Document document) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        Element restaurant = document.getDocumentElement();
        Element plat = document.createElement("plat");
        restaurant.appendChild(plat);

        Attr codi = document.createAttribute("codi");
        codi.setValue("P7");
        plat.setAttributeNode(codi);

        Element descripcio = document.createElement("descripcio");
        descripcio.appendChild(document.createTextNode("Spaghetti al pesto"));
        plat.appendChild(descripcio);

        Element categoria = document.createElement("categoria");
        categoria.appendChild(document.createTextNode("Pasta"));
        plat.appendChild(categoria);

        Element preu = document.createElement("preu");
        preu.appendChild(document.createTextNode("8"));
        plat.appendChild(preu);
        saveFile(document);
    }

    public static void saveFile(Document doc){
        try {
            File inputFIle = new File("/home/dam2a/Documents/accesadades/autoevaluacio/cartaplats.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(inputFIle);
            transformer.transform(domSource, streamResult);
        }catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try{
            addElements(createDoc());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
