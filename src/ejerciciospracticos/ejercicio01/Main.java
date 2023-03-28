package ejerciciospracticos.ejercicio01;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clase Principal
 */
public class Main {

    /*
    Crea un programa que muestre un menú al usuario como el siguiente:
        Elija qué comando desea ejecutar:
        1. Crear carpeta
        2. Crear fichero
        3. Mostrar contenido del directorio
    Atendiendo a la opción seleccionada por el usuario, el programa debe lanzar un proceso u otro. Toma de base el archivo
    ejercicio1.Ejercicio1.java que se adjunta a la tarea.
     */


    //TODO: Rehacer el ejercicio con un solo precessBuilder, y todo en el main, no con varias clases

    //Declaramos el scanner para poder leer por consola
    public static Scanner sc = new Scanner(System.in);

    /**
     * Método principal que lanza el menú y según la opción seleccionada por el usuario lanza un proceso u otro
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opc;        //Variable donde vamos a guardar la opción seleccionada por el usuario

        do {
            // Lanzamos el menú y guardamos la opción seleccionada por el usuario
            opc = menu();

            // Según la opción introducida debemos lanzar un proceso u otro.
            switch (opc) {
                case 0 -> System.out.println("Hasta pronto!");
                case 1 -> lanzarCrearCarpeta();
                case 2 -> lanzarCrearFichero();
                case 3 -> lanzarMostrarDirectorio();
                default -> System.out.println("La opcion introducida no es valida");
            }
        }while (opc != 0);

    }

    /**
     * Método que muestra el menú ppor pantalla y devuelve la opción seleccionada por el usuario
     * @ opcion seleccionada por el usuario
     */
    public static int menu() {
        // En opc guardaremos la opción seleccionada por el usuario
        int opc;

        // Imprimimos el menú con las diversas opciones
        System.out.println("Elija que comando desea ejecutar:");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear fichero");
        System.out.println("3. Mostrar contenido del directorio");
        System.out.println("0. Salir");

        // Leemos la opción de teclado
        opc = sc.nextInt();

        return opc;
    }

    /**
     * Método que lanza la clase CrearCarpeta
     */
    public static void lanzarCrearCarpeta() {

        //Declaramos la variable comando donde guardamos la ruta de la clase
        String[] comando = {"java", "src/ejerciciospracticos/ejercicio01/CrearCarpeta.java"};

        //Declaramos el ProcessBuilder y le pasamos el comando que acabamos de crear
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();                         //Iniciamos el proceso
            p.waitFor();                                    //Y esperamos a que acabe
        } catch (IOException e) {                           //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algun problema de E/S");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido algun proceso");
            System.out.println(e.getMessage());
        }
    }

   /**
    * Método que lanza la clase CrearFichero
    */
    public static void lanzarCrearFichero() {

        //Declaramos la variable comando donde guardamos la ruta de la clase
        String[] comando = {"java", "src/ejerciciospracticos/ejercicio01/CrearFichero.java"};

        //Declaramos el ProcessBuilder y le pasamos el comando que acabamos de crear
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();                         //Iniciamos el proceso
            p.waitFor();                                    //Y esperamos a que acabe
        } catch (IOException e) {                          //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algun problema de E/S");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido algun proceso");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que lanza la clase MostrarDirectorio
     */
    public static void lanzarMostrarDirectorio() {

        //Declaramos la variable comando donde guardamos la ruta de la clase
        String[] comando = {"java", "src/ejerciciospracticos/ejercicio01/MostrarDirectorio.java"};

        //Declaramos el ProcessBuilder y le pasamos el comando que acabamos de crear
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();                         //Iniciamos el proceso
            p.waitFor();                                    //Y esperamos a que acabe
        } catch (IOException e) {                           //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algun problema de E/S");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido algun proceso");
            System.out.println(e.getMessage());
        }
    }

}
