package ejerciciostema1.redireccion.entradasalida.ejercicio07;

public class Clase1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 256) + "." + (int) (Math.random() * 256) + "." + (int) (Math.random() * 256));
        }
    }
}
