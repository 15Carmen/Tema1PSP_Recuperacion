package ejerciciostema1.redireccion.processbuilder.ejercicio09;

import java.io.*;

/**
 * Realiza de nuevo el ejercicio 5, pero en vez de utilizar ProcessBuilder para lanzar la clase PreguntaNombre.java
 * utiliza la clase Runtime. Utiliza el método getOutputStream() de la clase Process para que tome los datos de un
 * fichero de texto, por ejemplo, entradaNombre.txt. Para poder ver la salida en la consola habrá que usar el método
 * getInputStream() e imprimirlo por pantalla.
 */
public class PreguntaNombreRuntime {
    public static void main(String[] args) {
        //Creamos un objeto de la clase Runtime
        Runtime rt = Runtime.getRuntime();
        //Creamos un array de String con el comando de la clase que queremos ejecutar
        String[] comando = {"java", "src/ejerciciostema1/redireccion/entradasalida/ejercicio05/PreguntaNombre.java"};

        try{

            //Ejecutamos el proceso y lo almacenamos en la clase Process
            Process p = rt.exec(comando);

            //Declaramos un BufferedReader y un FileReader para leer la salida del proceso 05
            BufferedReader br = new BufferedReader(new FileReader("src/ejerciciostema1/redireccion/entradasalida/ejercicio05/fichero.txt"));

            //Usamos el método getOutputStream() para tomar los datos del fichero del ejercicio 05
            OutputStream os = p.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            //Escribo en la entrada del proceso lo escrito en el fichero fichero.txt
            String line = br.readLine();
            while(line!=null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }

            //Cerramos los flujos
            bw.close();
            br.close();
            osw.close();

            //Creamos los flujos de salida del proceso
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br2 = new BufferedReader(isr);

            //Leemos la salida del proceso y la imprimimos por pantalla
            String line2 = br2.readLine();
            while(line2!=null) {
                System.out.println(line2);
                line2 = br2.readLine();
            }

            //Cerramos los flujos
            br2.close();
            isr.close();
            is.close();


        }catch(Exception e){
            System.out.println("Error al ejecutar el proceso");
        }
    }
}
