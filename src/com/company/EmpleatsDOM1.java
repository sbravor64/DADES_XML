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
import java.io.*;
import java.util.ArrayList;

public class EmpleatsDOM1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<User> listUser = new ArrayList<>();
        loadUsers(listUser);
        writeUsersToXML(listUser);
    }

    public  static void loadUsers(ArrayList<User> listUsers) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("/home/dam2a/Documents/accesadades/users.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        User usuario = (User) objectInputStream.readObject();

        try {
            while (true){
                listUsers.add(usuario);
                usuario= (User) objectInputStream.readObject();
            }
        }catch (EOFException e){
            fileInputStream.close();
            objectInputStream.close();
        }

        System.out.println(listUsers);
    }

    private static void writeUsersToXML(ArrayList<User> listUsers) throws IOException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("Empleats");
            document.appendChild(rootElement);

            for (User u : listUsers) {
                Element empleatElement = document.createElement("Empleat");

                Element usernameEmpleat = document.createElement("Username");
                empleatElement.appendChild(usernameEmpleat);
                usernameEmpleat.appendChild(document.createTextNode(u.getUsername()));

                Element nomEmpleat = document.createElement("Firstname");
                empleatElement.appendChild(nomEmpleat);
                nomEmpleat.appendChild(document.createTextNode(u.getFirstname()));

                Element cognomEmpleat = document.createElement("lastname");
                empleatElement.appendChild(cognomEmpleat);
                cognomEmpleat.appendChild(document.createTextNode(u.getLastname()));

                Element passEmpleat = document.createElement("Password");
                empleatElement.appendChild(passEmpleat);
                passEmpleat.appendChild(document.createTextNode(u.getPassword()));

                Element correoEmpleat = document.createElement("Email");
                empleatElement.appendChild(correoEmpleat);
                correoEmpleat.appendChild(document.createTextNode(u.getEmail()));

                rootElement.appendChild(empleatElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("/home/dam2a/Documents/accesadades/XML/empleats.xml"));
            transformer.transform(source,result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source,consoleResult);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
