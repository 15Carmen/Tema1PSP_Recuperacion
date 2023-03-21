package ejerciciostema1.redireccion.entradasalida.ejercicio06;

import java.util.Scanner;

public class TicketCompra {
    public static void main(String[] args) {
        //Declaramos las variables
        int codigo;     //Variable que guardará el código del producto
        double precio;  //Variable que guardará el precio del producto
        int cantidad;   //Variable que guardará la el numero de unidades que se han comprado del productos
        double total;   //Variable que guardará el total de la compra (precio*cantidad)
        //Declaramos el scanner
        Scanner sc = new Scanner(System.in);

        //Pedimos los datos al usuario
        codigo = sc.nextInt();
        precio = sc.nextDouble();
        cantidad = sc.nextInt();

        //Calculamos el total
        total = precio*cantidad;

        System.out.println("Código: " + codigo + " Precio: " + precio + " Cantidad: " + cantidad + " Total: " + total);
    }
}
