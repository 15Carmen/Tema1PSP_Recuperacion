package ejerciciostema1.redireccion.processbuilder.ejercicio08;

import java.io.*;

public class LanzarProcesoLentoRuntime {
    public static void main(String[] args) {

        //Creamos un objeto de la clase Runtime
        Runtime rt = Runtime.getRuntime();
        //Creamos un array de String con el comando de la clase que queremos ejecutar
        String[] comando = {"java", "src/ejerciciostema1/redireccion/entradasalida/ejercicio04/ProcesoLento.java"};

        try {
            //Ejecutamos el proceso y lo almacenamos en un objeto Process
            Process p = rt.exec(comando);

            //Creamos los flujos de entrada y salida para leer la salida del proceso
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            //Creamos el fichero de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/ejerciciostema1/redireccion/processbuilder/ejercicio08/salida.txt"));

            //Leemos la salida del proceso y la escribimos en el fichero
            String line = br.readLine();
            while(line!=null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }

            //Cerramos los flujos
            bw.close();
            br.close();
            isr.close();
            is.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar el proceso");
        }


    }
}
