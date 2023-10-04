package upb.TALLER3;

import java.io.IOException;
import java.text.DecimalFormat;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Taller3 {

    public static void main(String[] args) throws IOException {

        DecimalFormat formateo = new DecimalFormat("0.#####");
        String ruta = "C:\\books.csv";
        Libro[] libros = Libro.leerCSV(ruta);

        // -----------------------------------------------------------------------------------------------------

        // probando metodo shellShort en AverageRating
        Libro.averageRatingComparator myComparator = new Libro.averageRatingComparator();
        Libro.shellSort(libros, myComparator.reversed());
        for (Libro libro : libros) {
            StdOut.println(libro.toString());
        }

        // -----------------------------------------------------------------------------------------------------

        // punto 8 implementando el 7

        int k = 20;
        double timeSelection, timeArray, timeInsertion, timeShell, promInsertion, promArray, promSelection, promShell,
                acumuladoSelection = 0, acumuladoArray = 0, acumuladoinserton = 0, acumuladoShell = 0;

        for (int i = 1; i <= k; i++) {

            StdOut.println("\nmedicion #" + i + "\n");

            StdRandom.shuffle(libros);
            timeSelection = Libro.medirTiempoSelectionSort(libros, new Libro.averageRatingComparator());
            acumuladoSelection += timeSelection;
            StdOut.println("Time the Selection Sort: " + formateo.format(timeSelection) + " seg");

            StdRandom.shuffle(libros);
            timeArray = Libro.medirTiempoArraysSort(libros, new Libro.averageRatingComparator());
            acumuladoArray += timeArray;
            StdOut.println("Time the Array     Sort: " + formateo.format(timeArray) + " seg");

            StdRandom.shuffle(libros);
            timeInsertion = Libro.medirTiempoInsertionSort(libros, new Libro.averageRatingComparator());
            acumuladoinserton += timeInsertion;
            StdOut.println("Time the Insertion Sort: " + formateo.format(timeInsertion) + " seg");

            StdRandom.shuffle(libros);
            timeShell = Libro.medirTiempoShellSort(libros, new Libro.averageRatingComparator());
            acumuladoShell += timeShell;
            StdOut.println("Time the Shell     Sort: " + formateo.format(timeShell) + " seg");
        }

        StdOut.println("\n------------------averageRatingComparator------------------");

        promSelection = acumuladoSelection / k;
        StdOut.println("\nEl promedio de Selection con k=20 veces es de: " + formateo.format(promSelection) + " seg");
        promArray = acumuladoArray / k;
        StdOut.println("El promedio de Array     con k=20 veces es de: " + formateo.format(promArray) + " seg");
        promInsertion = acumuladoinserton / k;
        StdOut.println("El promedio de Insertion con k=20 veces es de: " + formateo.format(promInsertion) + " seg");
        promShell = acumuladoShell / k;
        StdOut.println("El promedio de Shell     con k=20 veces es de: " + formateo.format(promShell) + " seg\n");

        // ------------------------------------------------------------------------------------------------------
    }
}
