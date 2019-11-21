package com.company;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class EmpleatsDOM2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("/home/dam2a/Documents/accesadades/XML/empleats.xml");

            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            NodeList nlist = document.getElementsByTagName("Empleat");
            System.out.println("---------------------------");

            for (int i = 0; i < nlist.getLength() ; i++) {
                Node nNode = nlist.item(i);

                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nNode;
                    System.out.print("USERNAME: " + element.getElementsByTagName("Username").item(0).getTextContent());
                    System.out.print(", FIRSTNAME: " + element.getElementsByTagName("Firstname").item(0).getTextContent());
                    System.out.print(", LASTNAME: " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.print(", EMAIL: " + element.getElementsByTagName("Email").item(0).getTextContent());
                    System.out.print(", PASSWORD: " + element.getElementsByTagName("Password").item(0).getTextContent());
                    System.out.println("");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
