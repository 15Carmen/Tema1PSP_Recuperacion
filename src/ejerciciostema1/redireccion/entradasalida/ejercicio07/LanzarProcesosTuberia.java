package ejerciciostema1.redireccion.entradasalida.ejercicio07;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanzarProcesosTuberia {
    public static void main(String[] args) {

        //Creamos un proceso por cada clase que vamos a ejecutar
        ProcessBuilder pb1 = new ProcessBuilder("java", "src/ejerciciostema1/redireccion/entradasalida/ejercicio07/Clase1.java");
        ProcessBuilder pb2 = new ProcessBuilder("java", "src/ejerciciostema1/redireccion/entradasalida/ejercicio07/Clase2.java");
        ProcessBuilder pb3 = new ProcessBuilder("java", "src/ejerciciostema1/redireccion/entradasalida/ejercicio07/Clase3.java");

        //Creamos un array donde vamos a guardar los procesos
        List<ProcessBuilder> listaProcesos = new ArrayList<ProcessBuilder>();

        //Añadimos los procesos al array
        listaProcesos.add(pb1);
        listaProcesos.add(pb2);
        listaProcesos.add(pb3);

        //Redirigimos la salida de error de los procesos
        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb3.redirectError(ProcessBuilder.Redirect.INHERIT);

        //Redirigimos la salida del tercer proceso a un fichero
        pb3.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src/ejerciciostema1/redireccion/entradasalida/ejercicio07/listaIP.txt")));

        try{
            //Ejecutamos los procesos
            List<Process> lProcess = ProcessBuilder.startPipeline(listaProcesos);
        } catch (IOException e) {
            System.err.println("Error al ejecutar el proceso" + e.getMessage());
        }

    }
}
