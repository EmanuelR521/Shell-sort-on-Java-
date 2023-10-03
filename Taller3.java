package upb.TALLER3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

public class Taller3 {

    public static void main(String[] args) throws IOException {
        String ruta = "C:\\books.csv";
        Libro[] libros = leerCSV(ruta);

        Libro.averageRatingComparator myComparator = new Libro.averageRatingComparator();
        Selection.sort(libros, myComparator.reversed());

        for (Libro libro : libros) {
            StdOut.println(libro.toString());
        }

        /*
         * Libro.publicationDateComparator myDateComparator = new
         * Libro.publicationDateComparator();
         * Libro.listarPorComparador(libros, myDateComparator);
         * 
         * for (Libro libro : libros) {
         * StdOut.println(libro.toString());
         * }
         */

        /*
         * Libro.AuthorsComparator myauthorsComparator = new Libro.AuthorsComparator();
         * Libro.listarPorComparador(libros, myauthorsComparator);
         * 
         * for (Libro libro : libros) {
         * StdOut.println(libro.toString());
         * }
         */

        // -----------------------------------------------------------------------------------------------------
        // pruebas punto 7

        Libro librito = new Libro();
        double timeSelectionSort = librito.medirTiempoSelectionSort(libros, new Libro.AuthorsComparator());
        StdOut.println("Time the Selection Sort: " + timeSelectionSort + " seg");

        double timeQuickSort = librito.medirTiempoArraysSort(libros, new Libro.AuthorsComparator());
        StdOut.println("Time the Array Sort: " + timeQuickSort + " seg");

        double timeInsertionSort = librito.medirTiempoInsertionSort(libros, new Libro.AuthorsComparator());
        StdOut.println("Time the Insertion Sort: " + timeInsertionSort + " seg");

        // ------------------------------------------------------------------------------------------------------

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
            libros[i] = new Libro(datos[0], datos[1], datos[2],
                    Float.parseFloat(datos[3]), datos[4], datos[5],
                    datos[6], Integer.parseInt(datos[7]), Integer.parseInt(datos[8]),
                    Integer.parseInt(datos[9]), datos[10], datos[11]);
            i++;
        }
        br.close();
        return libros;
    }

}
