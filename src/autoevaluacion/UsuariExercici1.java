package autoevaluacion;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class UsuariExercici1 {

    static File inputFIle = new File("C:\\Users\\Usuario\\Documents\\ANDRES\\accesDades\\cartaplats.xml");
    //static File inputFIle = new File("/home/dam2a/Documents/accesadades/autoevaluacio/cartaplats.xml");

    public static  Document createDoc(){
        Document document = null;
        try{
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFIle);
            document.getDocumentElement().normalize();
        }catch (Exception e){
            e.printStackTrace();
        }
        return document;
    }

    public static void addElements(Document document) {
        Element restaurant = document.getDocumentElement();
        Element plat = document.createElement("plat");

        Attr codi = document.createAttribute("codi");
        codi.setValue("P7");
        plat.setAttributeNode(codi);

        Element descripcio = document.createElement("descripcio");
        descripcio.appendChild(document.createTextNode("Spaghetti al pesto"));

        Element categoria = document.createElement("categoria");
        categoria.appendChild(document.createTextNode("Pasta"));

        Element preu = document.createElement("preu");
        preu.appendChild(document.createTextNode("8"));

        plat.appendChild(categoria);
        restaurant.appendChild(plat);
        plat.appendChild(preu);
        plat.appendChild(descripcio);

        saveFile(document);
    }

    public static void saveFile(Document doc){
        try {
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
