package ejerciciostema1.redireccion.entradasalida.ejercicio07;

import java.util.Scanner;

public class Clase2 {
    public static void main(String[] args) {

        //Declaramos las variables
        String ip;
        String[] direccionOctetos;
        int octeto;

        //Declaramos el scanner
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            ip = sc.nextLine(); //Leemos la ip
            direccionOctetos = ip.split("\\."); //Separamos la ip en octetos
            octeto = Integer.parseInt(direccionOctetos[0]); //Obtenemos el primer octeto
            if(octeto <= 223){ //Si el primer octeto es menor o igual que 223 es una ip de clase A, B o C
                System.out.println(ip); //Por lo tanto la imprimimos por pantalla
            }
        }
    }
}
