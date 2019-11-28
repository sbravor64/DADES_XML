package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

class EmpleatHandler extends DefaultHandler{
    boolean bUsername = false;
    boolean bFirstname = false;
    boolean bLastname = false;
    boolean bPassword = false;
    boolean bEmail = false;

    public void startElement (String uri, String localName, String qName, Attributes attributes) {
        if(qName.equalsIgnoreCase("Empleat")){
            System.out.println("----------------------");
        } else if(qName.equalsIgnoreCase("Username")){
            bUsername = true;
        } else if(qName.equalsIgnoreCase("Firstname")){
            bFirstname = true;
        } else if(qName.equalsIgnoreCase("lastname")){
            bLastname = true;
        } else if(qName.equalsIgnoreCase("Password")){
            bPassword = true;
        } else if(qName.equalsIgnoreCase("Email")){
            bEmail = true;
        }
    }

    public void characters(char ch[], int start, int length){
        if(bUsername){
            System.out.println("Username: " + new String(ch, start, length));
            bUsername = false;
        } else if(bFirstname){
            System.out.println("Firstname: " + new String(ch, start, length));
            bFirstname = false;
        } else if(bLastname){
            System.out.println("lastname: " + new String(ch, start, length));
            bLastname = false;
        } else if(bPassword){
            System.out.println("Password: " + new String(ch, start, length));
            bPassword = false;
        } else if(bEmail){
            System.out.println("Email: " + new String(ch, start, length));
            bEmail = false;
        }
    }
}

public class EmpleatsSAX {

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
        File inputFile = new File("/home/dam2a/Documents/accesadades/XML/empleats.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser= saxParserFactory.newSAXParser();
        EmpleatHandler empleatHandler = new EmpleatHandler();
        parser.parse(inputFile, empleatHandler);
    }

}
