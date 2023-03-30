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

    //Declaramos el scanner para poder leer por consola
    public static Scanner sc = new Scanner(System.in);

    /**
     * Método principal que lanza el menú y según la opción seleccionada por el usuario lanza un proceso u otro
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opc;        //Variable donde vamos a guardar la opción seleccionada por el usuario
        String ruta;            //Variable donde vamos a guardar la ruta introducida por el usuario
        String nombreFichero;   //Variable donde vamos a guardar el nombre del fichero introducido por el usuario

        do {
            // Lanzamos el menú y guardamos la opción seleccionada por el usuario
            opc = menu();

            // Según la opción introducida debemos lanzar un proceso u otro.
            switch (opc) {
                case 0 -> System.out.println("Hasta pronto!");
                case 1 -> {

                    //Le pedimos al usuario que introduzca el nombre de la carpeta que quiere crear
                    System.out.println("Introduzca la ruta donde quiere crear la carpeta junto con el nombre de la carpeta que desea crear: ");
                    ruta = sc.next();

                    //Declaramos la variable comandoCarpeta donde guardamos el comando para crear la carpeta
                    String[] comandoCarpeta = {"cmd", "/C", "md",  ruta};

                    //Lanzamos el proceso
                    lazarProceso(comandoCarpeta);
                }
                case 2 ->{

                    //Le pedimos al usuario que introduzca el nombre del fichero y la ruta donde quiere crearlo
                    System.out.println("Introduzca el nombre del fichero que quiere crear: ");
                    nombreFichero = sc.next();
                    System.out.println("Introduzca la ruta donde quiere crear el fichero: ");
                    ruta = sc.next();

                    //Declaramos la variable comandoFichero donde guardamos el comando para crear el fichero
                    String[] comandoFichero = new String[]{"cmd", "/C", "type", "nul", ">", ruta+"\\"+nombreFichero};

                    //Lanzamos el proceso
                    lazarProceso(comandoFichero);
                }
                case 3 -> {

                    //Le pedimos al usuario que introduzca la ruta del directo que quiere consultar y lo guardamos en la variable ruta
                    System.out.println("Introduzca la ruta del directorio que quiere consultar: ");
                    ruta = sc.next();

                    //Declaramos la variable comandoDirectorio donde guardamos el comando para mostrar el contenido del directorio
                    String[] comandoDirectorio = {"cmd", "/C", "dir", ruta};

                    //Lanzamos el proceso
                    lazarProceso(comandoDirectorio);
                }
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
        System.out.println();
        System.out.println("Elija que comando desea ejecutar:");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear fichero");
        System.out.println("3. Mostrar contenido del directorio");
        System.out.println("0. Salir");
        System.out.println();

        // Leemos la opción de teclado
        opc = sc.nextInt();

        return opc;
    }

    /**
     * Método que lanza el proceso que se le pasa por parámetro
     * @param comando comando que se va a lanzar
     */
    public static void lazarProceso(String[] comando) {

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
