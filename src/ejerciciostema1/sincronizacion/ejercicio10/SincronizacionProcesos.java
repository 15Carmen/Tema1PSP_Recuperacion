package ejerciciostema1.sincronizacion.ejercicio10;

import java.io.IOException;

public class SincronizacionProcesos {
    public static void main(String[] args) {
        //Declaramos los comandos que vamos a utilizar

        //Comando que va a crear la carpeta1
        String[] comando1 = {"cmd", "/C", "md", "C:\\pruebas\\carpera1"};

        //Comando que va a crear el fichero1
        String[] comando2 = {"cmd", "/C", "type", "nul", ">", "C:\\pruebas\\carpera1\\fichero1.txt"};

        //Comando que va a abrir el fichero1 en notepad
        String[] comando3 = { "notepad", "C:\\pruebas\\carpera1\\fichero1.txt"};

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
