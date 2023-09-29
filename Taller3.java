package upb.Taller33;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class Taller3 {

    public static void main(String[] args) throws IOException{
        String ruta = "C:\\Books.csv";
        
        Libro[] libros = leerCSV(ruta);
        listaPorRating(libros);
        for (Libro libro : libros) {
            StdOut.println(libro.toString());
        }

    }

    public static Libro[] listaPorRating(Libro[] x){
        Arrays.sort(x,(a,b) -> a.compareTo(b));
        return x;
    }

     public static Libro[] leerCSV(String ruta) throws IOException {
        Libro[] libros = new Libro[11127];
        int i = 0;
        BufferedReader br = null;
        String line = "";
        // Se define separador ","
        String splitBy = ",";
        br = new BufferedReader(new FileReader(ruta));
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(splitBy);
            libros[i] = new Libro(datos[0],datos[1],datos[2],
            Float.parseFloat(datos[3]),datos[4],datos[5],
            datos[6],Integer.parseInt(datos[7]),Integer.parseInt(datos[8]),
            Integer.parseInt(datos[9]),datos[10],datos[11]);
            i++;
        }
        br.close();
        return libros;
    }


    
}
