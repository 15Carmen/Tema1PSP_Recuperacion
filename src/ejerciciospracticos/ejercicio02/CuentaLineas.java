package ejerciciospracticos.ejercicio02;

import java.util.Scanner;

/**
 * Clase que va a contar el numero de lineas que tiene un fichero de texto
 */
public class CuentaLineas {
    public static void main(String[] args) {
        //Declaramos las variables
        int numLineas = 0;  //Variable donde vamos a guardar el numero de lineas que el programa cuente

        //Declaramos el scanner para poder leer por consola
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {      // Mientras haya una línea
            numLineas++;                //Incrementamos en 1 la variable numLineas
            sc.nextLine();              // Paso a la siguiente línea
        }

        //Imprimimos el número total de líneas contabilizadas
        System.out.print("El fichero tiene "+ numLineas +" lineas");

        //Cerramos el scanner
        sc.close();
    }
}
