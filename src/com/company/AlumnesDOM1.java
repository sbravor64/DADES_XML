package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class AlumnesDOM1 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("Alumnes");
            document.appendChild(rootElement);

            Element alumne = document.createElement("Alumne");
            Attr edat = document.createAttribute("edat");
            edat.setValue("19");
            alumne.setAttributeNode(edat);
            rootElement.appendChild(alumne);

            Element dniElement = document.createElement("DNI");
            dniElement.appendChild(document.createTextNode("X1234567T"));
            alumne.appendChild(dniElement);

            Element nomElement = document.createElement("Nom");
            nomElement.appendChild(document.createTextNode("Andrés"));
            alumne.appendChild(nomElement);

            Element cognom1Element = document.createElement("Cognom1");
            cognom1Element.appendChild(document.createTextNode("Bravo"));
            alumne.appendChild(cognom1Element);

            Element cognom2Element = document.createElement("Cognom2");
            cognom2Element.appendChild(document.createTextNode("Ruiz"));
            alumne.appendChild(cognom2Element);

            Element ciutatElement = document.createElement("Ciutat");
            ciutatElement.appendChild(document.createTextNode("Barcelona"));
            alumne.appendChild(ciutatElement);

            Element assignaturesElement = document.createElement("Assignatures");
            assignaturesElement.appendChild(document.createTextNode("Acces a Dades"));
            alumne.appendChild(assignaturesElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("/home/dam2a/Documents/accesadades/XML/alumnos.xml"));
            transformer.transform(source,result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source,consoleResult);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
