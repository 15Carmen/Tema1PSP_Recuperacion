package ejerciciospracticos.ejercicio02;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Clase Principal
 */
public class Main {
    /**
     * Crea una clase que lance los siguientes procesos y que sincronice la ejecución entre ellos:
     * <p>
     * Proceso 1: Debe abrir la aplicación bloc de notas. El usuario debe escribir en él una serie de líneas. Cuando
     * termine de escribir, guardará el fichero y cerrará el bloc de notas. El fichero a guardar debe llamarse
     * numLineas.txt y guardarse en la carpeta C:\ejercicio2.
     * <p>
     * Proceso 2: Debe lanzar una clase Java que se llamará CuentaLineas.java.
     * La clase CuentaLineas.java debe leer de la entrada estándar una serie de líneas (no sabemos cuántas) y devolver
     * el número de líneas que ha leído.
     * <p>
     * El proceso 2 debe redireccionar la entrada estándar de forma que ésta sea el fichero numLineas.txt creado por
     * el Proceso 1. La salida estándar y la de error del Proceso 2 deben redirigirse hacia las del proceso padre
     * (es decir, la consola).
     * <p>
     * El Proceso 2 debe esperar a que el Proceso 1 termine para así poder leer del fichero, pero si el Proceso 1
     * tarda más de 30 segundos en terminar, se debe de terminar la ejecución del proceso, mostrando el mensaje de
     * error correspondiente.
     */

    //Declaramos un file fichero que es el que vamos a abrir con el block de notas
    private static final File FICHERO = new File("C:\\ejercicio2\\numLineas.txt");
    //Declaramos un file carpeta con la ruta donde vamos a guardar el fichero

    public static void main(String[] args) {

        //Declaramos los comandos que vamos a utilizar

        //Comando que va a abrir el fichero numLineas.txt en el block de notas
        String[] comando1 = {"notepad", String.valueOf(FICHERO)};
        //Comando que va a ejecutar el programa CuentaLineas.java
        String[] comando2 = {"java", "src/ejerciciospracticos/ejercicio02/CuentaLineas.java"};


        //Declaramos 2 ProcessBuilder y les pasamos los dos comandos creados previamente
        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        ProcessBuilder pb2 = new ProcessBuilder(comando2);

        //Redirijo la entrada del proceso2 al fichero
        pb2.redirectInput(ProcessBuilder.Redirect.from(new File("C:\\ejercicio2\\numLineas.txt")));

        //Redirijo la salida y la salida de error del proceso2 a la consola
        pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb1.inheritIO();

        try {

            Process p1 = pb1.start();    //Ejecutamos el proceso 1

            if (p1.waitFor(30, TimeUnit.SECONDS)) {  //Si el proceso 1 tarda menos de 30 segundos en terminar, se ejecuta el proceso 2
                Process p2 = pb2.start();                   //Ejecutamos el proceso 2
                p2.waitFor();                               //Esperamos a que termine el proceso 2
            } else {                                        //Si el proceso 1 tarda más de 30 segundos en terminar
                p1.destroy();                               //Terminamos el proceso 1
                //Mostramos un mensaje de error
                System.out.println("El proceso 1 ha tardado mas de 30 segundos en terminar");
            }
        } catch (
                IOException e) {                           //Si hay algún error en la ejecución de los procesos, se muestra el mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algún problema de E/S");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido algún proceso");
            System.out.println(e.getMessage());
        }
    }
}
