package ejerciciostema1.redireccion.entradasalida.ejercicio06;

import java.io.File;

public class LanzarTicketCompra {
    public static void main(String[] args) {
        //Declaramos el ProcessBuilder y le pasamos el comando para ejecutar el programa PreguntaNombre
        ProcessBuilder pb = new ProcessBuilder("java", "src/ejerciciostema1/redireccion/entradasalida/ejercicio06/TicketCompra.java");

        //Le decimos que el proceso va a leer de una entrada estándar y que va a escribir en un fichero
        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        //Usamos el método appendTo para que no sobreescriba el fichero, sino que añada los datos al final del mismo
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src/ejerciciostema1/redireccion/entradasalida/ejercicio06/compras.txt")));

        try{
            //Ejecutamos el proceso
            pb.start();
        }catch (Exception e){
            //Si el proceso falla lanzamos un mensaje de error
            System.err.println("Error al ejecutar el proceso" + e.getMessage());
        }
    }
}
