package autoevaluacion;

import java.io.*;
import java.util.ArrayList;

class User implements Serializable{

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public User(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " " + firstname + " " + lastname  + " " + email + " " +password;
    }
}

public class CSVToObjectFile {

    //Directorio del fichero binaro
    //static String directorioBinario = "/home/dam2a/Documents/accesadades/fichero.bin";
    static String directorioBinario = "C:\\Users\\Usuario\\Documents\\ANDRES\\accesDades\\fichero.bin";

    //Directorio del fichero CSV
    //static String directorioCSV = "/home/dam2a/Documents/accesadades/fichero.bin";
    static String directorioCSV = "C:\\Users\\Usuario\\Documents\\ANDRES\\accesDades\\fichero.csv";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File(directorioCSV);
        BufferedReader br = new BufferedReader(new FileReader(file));

        loadUsers(br);
        readDades();

    }

    public static void loadUsers(BufferedReader br) throws IOException, ClassNotFoundException {
        ArrayList<User> listusers = new ArrayList<>();

        String linea=br.readLine();

        while (linea!=null){
            String[] datos = linea.split(",");

            User user = new User(datos[0],datos[1],datos[2],datos[3],datos[4]);
            listusers.add(user);

            linea=br.readLine();
        }
        br.close();

        writeUsers(listusers);

    }

    public static void writeUsers(ArrayList<User> listUser) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(directorioBinario);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (User u : listUser) {
            objectOutputStream.writeObject(u);
        }
        objectOutputStream.close();
    }

    public static void readDades() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(directorioBinario);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        User user = (User) objectInputStream.readObject();

//        for (User u : users){
//            System.out.println(u.getFirstname());
//        }

        try {
            while (true){
                System.out.println(user);
                user= (User) objectInputStream.readObject();
            }
        }catch (EOFException e){
            fileInputStream.close();
            objectInputStream.close();
        }
    }
}


