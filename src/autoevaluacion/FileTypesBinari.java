package autoevaluacion;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class FileTypesBinari {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {


        //String directorio = "/home/dam2a/Documents/accesadades/fichero.txt";
        String directorio = "C:\\Users\\Usuario\\Documents\\ANDRES\\accesDades\\fichero.txt";

        FileOutputStream sortida = new FileOutputStream(directorio);
        DataOutputStream dataOutputStream = new DataOutputStream(sortida);

        dataOutputStream.writeByte(22);
        dataOutputStream.writeBoolean(false);
        dataOutputStream.writeChar('z');
        dataOutputStream.writeDouble(1.5);
        dataOutputStream.writeFloat(3.6f);
        dataOutputStream.writeLong(5);
        dataOutputStream.writeBytes("hola");

        dataOutputStream.close();

        FileReader fr = new FileReader(directorio);
        BufferedReader br = new BufferedReader(fr);

        String line=br.readLine();

        while (line!=null){
            System.out.println(line);
            line=br.readLine();
        }
        fr.close();
        br.close();

        System.out.println("-----------");

        FileInputStream fileInputStream = new FileInputStream(directorio);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);


        while (dataInputStream.available() > 0) {
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.readLong());
            System.out.println(dataInputStream.readLine());
        }
        fileInputStream.close();
        dataInputStream.close();

    }

}
