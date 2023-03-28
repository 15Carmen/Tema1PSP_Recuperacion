package ejerciciostema1.sincronizacion.ejercicio11;

import java.io.File;
import java.io.IOException;

public class SincronizacionProcesos2 {
    public static void main(String[] args) {
        //Declaramos los comandos que vamos a utilizar

        //Comando que va a crear el fichero1
        String[] comando1 = {"cmd", "/C", "type", "nul", ">", "C:\\pruebas\\carpera1\\fichero2.txt"};

        //Comando que va a abrir el fichero1 en notepad
        String[] comando2 = { "notepad", "C:\\pruebas\\carpera1\\fichero2.txt"};

        //Comando que va a llamar a la clase LeerFichero
        String[] comando3 = {"java", "src/ejerciciostema1/sincronizacion/ejercicio11/LeerFichero.java"};

        //Creamos los objetos de la clase ProcessBuilder
        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        ProcessBuilder pb3 = new ProcessBuilder(comando3);


        //Hacemos que los procesos hereden la entrada y la salida estandar
        pb1.inheritIO();
        pb2.inheritIO();
        pb3.inheritIO();

        try {

            Process p1 =pb1.start();    //Ejecutamos el proceso 1
            p1.waitFor();               //Esperamos a que termine el proceso 1 para ejecutar el siguiente proceso
            Process p2 =pb2.start();    //Ejecutamos el proceso 2
            p2.waitFor();               //Esperamos a que termine el proceso 2 para ejecutar el siguiente proceso
            Process p3 =pb3.start();    //Ejecutamos el proceso 3
            p3.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
