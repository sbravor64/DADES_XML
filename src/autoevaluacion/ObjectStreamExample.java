package autoevaluacion;

import java.io.*;
import java.util.ArrayList;

// ejercicio para escribir objetos en un archivo .bin
// y poder leer el fichero a través de un arraylist

class Person implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ObjectStreamExample {

    //static String directorio = "/home/dam2a/Documents/accesadades/fichero.bin";
    static String directorio = "C:\\Users\\Usuario\\Documents\\ANDRES\\accesDades\\fichero.bin";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("Andres Bravo");

        Person person2 = new Person();
        person2.setName("Jesus Bravo");

        Person person3 = new Person();
        person3.setName("Kevin Bravo");

        ArrayList<Person> listaPersones = new ArrayList<Person>();
        listaPersones.add(person);
        listaPersones.add(person2);
        listaPersones.add(person3);

        introDades(listaPersones);
        readDades();
    }

    public static void introDades(ArrayList<Person> listaPersones) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(directorio, false);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (int i = 0; i <listaPersones.size() ; i++) {
            objectOutputStream.writeObject(listaPersones.get(i));
        }

        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static void readDades() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(directorio);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ArrayList<Person> ps = new ArrayList<Person>();
       try {
           while (true){
               ps.add((Person) objectInputStream.readObject());
           }
       }catch (EOFException e){
           fileInputStream.close();
           objectInputStream.close();
       }

        for (Person p : ps){
            System.out.println(p.getName());
        }
    }
}


