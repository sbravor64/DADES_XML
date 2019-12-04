package autoevaluacion;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

class platsHandler extends DefaultHandler {
    boolean bDescripcio = false;
    boolean bCategoria = false;
    boolean bPreu = false;
    int i=1;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName.toLowerCase()) {
            case "plat":
                System.out.println("----------------------");
                System.out.println("Plat " + i++);
                String codi = attributes.getValue("codi");
                System.out.println("Codi: " + codi);
                break;
            case "descripcio":
                bDescripcio = true;
                break;
            case "categoria":
                bCategoria = true;
                break;
            case "preu":
                bPreu = true;
                break;
        }
    }

    public void characters(char ch[], int start, int length) {
        if (bDescripcio) {
            System.out.println("descripcio: " + new String(ch, start, length));
            bDescripcio = false;
        } else if (bCategoria) {
            System.out.println("categoria: " + new String(ch, start, length));
            bCategoria = false;
        } else if (bPreu) {
            System.out.println("preu: " + new String(ch, start, length));
            bPreu = false;
        }

    }
}

public class UsuariExercici2 {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        File inputFile = new File("C:\\Users\\Usuario\\Documents\\ANDRES\\accesDades\\cartaplats.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();
        platsHandler alumneHandler = new platsHandler();
        parser.parse(inputFile, alumneHandler);
    }
}
