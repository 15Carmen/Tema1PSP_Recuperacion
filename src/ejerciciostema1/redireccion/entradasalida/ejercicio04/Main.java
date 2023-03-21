package ejerciciostema1.redireccion.entradasalida.ejercicio04;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        String comando[] = {"java", "src/ejerciciostema1.redireccion.entradasalida/ejercicio4/ProcesoLento.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);

        //pb.inheritIO();

        //redireccionar salida
        pb.redirectOutput(new File("salidaProcesoLento.txt"));  //Hacemos que la salida del proceso se guarde en un fichero
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);

        try{
            pb.start();
        }catch (Exception e){
            System.err.println("Error al ejecutar el proceso" + e.getMessage());
        }


    }
}