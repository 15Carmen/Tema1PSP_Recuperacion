package ejerciciostema1.redireccion.entradasalida.ejercicio07;

import java.util.Scanner;

public class Clase3 {
    public static void main(String[] args) {

        //Declaramos las variables
        String ip;
        String[] ipArray;
        int octeto;

        //Declaramos el scanner
        Scanner sc = new Scanner(System.in);

        //
        while (sc.hasNextLine()){
            ip = sc.nextLine(); //Leemos la ip
            ipArray = ip.split("\\."); //Separamos la ip en octetos
            octeto = Integer.parseInt(ipArray[0]); //Obtenemos el primer octeto

            if(octeto <= 127) { //Si el primer octeto es menor o igual que 127 es una ip de clase A
                System.out.println("La ip: " + ip + " es una ip de la calse A");
            } else if (octeto >= 192){  //Si el primer octeto es mayor o igual que 192 es una ip de clase C
                System.out.println("La ip: " + ip + " es una ip de la calse C");
            }else { //Si no es una ip de clase A ni de clase C es una ip de clase B
                System.out.println("La ip: " + ip + " es una ip de la clase B");
            }
        }

    }
}
