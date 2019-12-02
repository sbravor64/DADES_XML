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

    class PlatsHandler extends DefaultHandler {
        boolean bDNI = false;
        boolean bNom = false;
        boolean bCognom1 = false;
        boolean bCognom2 = false;
        boolean bCiutat = false;
        boolean bAssignatures = false;

        public void startElement (String uri, String localName, String qName, Attributes attributes) {
            switch (qName.toLowerCase()){
                case "alumne":
                    System.out.println("----------------------");
                    String edat = attributes.getValue("edat");
                    System.out.println("Edat: " + edat);
                    break;
                case "dni":
                    bDNI = true;
                    break;
                case "nom":
                    bNom = true;
                    break;
                case "cognom1":
                    bCognom1 = true;
                    break;
                case  "cognom2":
                    bCognom2 = true;
                    break;
                case "ciutat":
                    bCiutat = true;
                    break;
                case "assignatures":
                    bAssignatures = true;
                    break;
            }
        }

        public void characters(char ch[], int start, int length){
            if(bDNI){
                System.out.println("DNI: " + new String(ch, start, length));
                bDNI = false;
            } else if(bNom){
                System.out.println("NOM: " + new String(ch, start, length));
                bNom = false;
            } else if(bCognom1){
                System.out.println("COGNOM 1: " + new String(ch, start, length));
                bCognom1 = false;
            } else if(bCognom2){
                System.out.println("COGNOM 2: " + new String(ch, start, length));
                bCognom2 = false;
            } else if(bCiutat){
                System.out.println("CIUTAT: " + new String(ch, start, length));
                bCiutat = false;
            } else if(bAssignatures){
                System.out.println("ASSIGNATURES: " + new String(ch, start, length));
                bAssignatures = false;
            }
        }

    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException {
        File inputFile = new File("/home/dam2a/Documents/accesadades/XML/alumnos.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser= saxParserFactory.newSAXParser();
    }

}
