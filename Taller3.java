package upb.TALLER3;

import java.io.IOException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Taller3 {

    public static void main(String[] args) throws IOException {

        String ruta = "C:\\books.csv";
        Libro[] libros = Libro.leerCSV(ruta);

        // -----------------------------------------------------------------------------------------------------
        // punto 8 implementando el 7

        int k = 20;
        double timeSelectionSort, timeArraySort, timeInsertionSort;
        double promedioinsertion, promedioArray, promedioSelection;
        double acumuladoSelection = 0, acumuladoArray = 0, acumuladoinserton = 0;

        for (int i = 1; i <= k; i++) {

            StdOut.println("\nmedicion #" + i + "\n");

            StdRandom.shuffle(libros);
            timeSelectionSort = Libro.medirTiempoSelectionSort(libros, new Libro.averageRatingComparator());
            acumuladoSelection += timeSelectionSort;
            StdOut.println("Time the Selection Sort: " + timeSelectionSort * Math.pow(10, -9) + " seg");

            StdRandom.shuffle(libros);
            timeArraySort = Libro.medirTiempoArraysSort(libros, new Libro.averageRatingComparator());
            acumuladoArray += timeArraySort;
            StdOut.println("Time the Array Sort: " + timeArraySort * Math.pow(10, -9) + " seg");

            StdRandom.shuffle(libros);
            timeInsertionSort = Libro.medirTiempoInsertionSort(libros, new Libro.averageRatingComparator());
            acumuladoinserton += timeInsertionSort;
            StdOut.println("Time the Insertion Sort: " + timeInsertionSort * Math.pow(10, -9) + " seg");
        }

        promedioSelection = acumuladoSelection / k;
        StdOut.println(
                "\nel promedio de Selection con k=20 veces es de: " + promedioSelection * Math.pow(10, -9) + " seg");
        promedioArray = acumuladoArray / k;
        StdOut.println(
                "el promedio de Array con k=20 veces es de: " + promedioArray * Math.pow(10, -9) + " seg");
        promedioinsertion = acumuladoinserton / k;
        StdOut.println(
                "el promedio de Insertion con k=20 veces es de: " + promedioinsertion * Math.pow(10, -9) + " seg\n");

        // ------------------------------------------------------------------------------------------------------

    }

}
