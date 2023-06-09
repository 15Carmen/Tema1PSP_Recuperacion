package ejerciciospracticos.ejercicio03;

import java.io.IOException;

/**
 * Clase Principal en la que los procesos se esperan entre sí
 */
public class MainEspera {
    /**
     * Crea un programa que cuente las vocales de un fichero de texto que se adjunta a la tarea (fichero_texto.txt).
     * Para ello crea una clase que lance la clase CuentaCaracteres.java (se adjunta a la tarea) 5 veces en paralelo,
     * una por cada vocal. La clase CuentaCaracteres.java lee el carácter a contar por la línea de argumentos, por lo
     * que habrá indicarle el carácter a buscar en el momento de construir el proceso. La salida de todos los procesos
     * debe ser la salida estándar, la heredada por el padre.
     *
     * Realiza dos ejecuciones, una en la que cada proceso espere al anterior y otra en la que los procesos no se
     * esperen entre sí. Cuenta la cantidad de milisegundos que transcurren entre los dos casos. ¿Hay alguna
     * diferencia? Pon cada solución en dos clases distintas.
     */

    public static void main(String[] args) {
        //Declaramos las variables
        double comienzo = System.currentTimeMillis();   //Variable donde vamos a guardar el tiempo de inicio del programa
        double fin;                                     //Variable donde vamos a guardar el tiempo de finalización del programa

        //Declaramos 5 ProcessBuilder, uno por cada vocal
        ProcessBuilder pb1 = new ProcessBuilder("java","src/ejerciciospracticos/ejercicio03/CuentaCaracteres.java","a");
        ProcessBuilder pb2 = new ProcessBuilder("java","src/ejerciciospracticos/ejercicio03/CuentaCaracteres.java","e");
        ProcessBuilder pb3 = new ProcessBuilder("java","src/ejerciciospracticos/ejercicio03/CuentaCaracteres.java","i");
        ProcessBuilder pb4 = new ProcessBuilder("java","src/ejerciciospracticos/ejercicio03/CuentaCaracteres.java","o");
        ProcessBuilder pb5 = new ProcessBuilder("java","src/ejerciciospracticos/ejercicio03/CuentaCaracteres.java","u");

        //E indicamos que su E/S por consola
        pb1.inheritIO();
        pb2.inheritIO();
        pb3.inheritIO();
        pb4.inheritIO();
        pb5.inheritIO();

        try {
            //Comenzamos los procesos y esperamos a que termine uno para comenzar el siguiente
            Process p1 = pb1.start();
            p1.waitFor();
            Process p2 = pb2.start();
            p2.waitFor();
            Process p3 = pb3.start();
            p3.waitFor();
            Process p4 = pb4.start();
            p4.waitFor();
            Process p5 = pb5.start();
            p5.waitFor();

        } catch (IOException e) { //Si hay algún problema con los procesos lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algún problema de E/S");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido algún proceso");
            System.out.println(e.getMessage());
        }

        //Marcamos este como el fin del programa y lo guardamos en la variable fin
        fin = System.currentTimeMillis();

        //Imprimimos por consola el tiempo de ejecución total del programa, que es el fin de este menos el comienzo
        System.out.println("El tiempo de ejecución sin esperas es de " + (fin-comienzo) + " milisegundos");
    }
}
