package redireccion.entradasalida.ejercicio5;

import java.util.Scanner;

public class PreguntaNombre {
    public static void main(String[] args) {

        //Declaramos las variables
        String nombre;          //Variable donde vamos a guardar el nombre introducido por el usuario

        //Declaramos el scanner par poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Guardamos el nombre introducido por el usuario en la variable nombre
        nombre = sc.nextLine();

        //Imprimimos por pantalla el nombre introducido por el usuario
        System.out.println("Hola " + nombre);

        //Cerramos el scanner
        sc.close();

    }
}
