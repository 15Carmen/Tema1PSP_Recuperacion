package ejerciciostema1.redireccion.entradasalida.ejercicio05;

import java.io.File;

public class LanzaProceso {
    public static void main(String[] args) {
        //Declaramos el ProcessBuilder y le pasamos el comando para ejecutar el programa PreguntaNombre
        ProcessBuilder pb = new ProcessBuilder("java", "src/ejerciciostema1.redireccion/entradasalida/ejercicio5/PreguntaNombre.java");

        //Le decimos que el proceso va a leer de un fichero y que va a escribir en la consola
        pb.redirectInput(new File("src/ejerciciostema1.redireccion.entradasalida/ejercicio5/fichero.txt"));
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try{
            //Ejecutamos el proceso
            pb.start();
        }catch (Exception e){
            //Si el proceso falla lanzamos un mensaje de error
            System.err.println("Error al ejecutar el proceso" + e.getMessage());
        }
    }
}
