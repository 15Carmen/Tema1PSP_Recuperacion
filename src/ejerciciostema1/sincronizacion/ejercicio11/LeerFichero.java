package ejerciciostema1.sincronizacion.ejercicio11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerFichero {
    public static void main(String[] args) {

        //Declaramos las variables
        File archivo;               //Variable de tipo File que va a contener el fichero que vamos a leer
        FileReader fr = null;       //Variable de tipo FileReader que va a contener el objeto File
        BufferedReader br;          //Variable de tipo BufferedReader que va a contener el objeto FileReader
        String linea;               //Variable de tipo String que va a contener la linea que vamos a leer

        try {
            //Introducimos la ruta del fichero que vamos a leer
            archivo = new File ("C:\\pruebas\\carpera1\\fichero2.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            //Leemos el fichero linea a linea
            while((linea=br.readLine())!=null) {  //Mientras la linea no sea nula
                System.out.println(linea);       //Imprimimos la linea que leemos
            }

            //Cerramos los objetos
            fr.close();
            br.close();

        }
        catch(Exception e){
            System.err.println("Ha habido un problema: " + e.getMessage());
        }
    }
}
