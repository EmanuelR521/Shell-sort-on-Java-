package upb.TALLER3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

public class Libro {

    private String bookId;
    private String title;
    public String authors;
    public Float averageRating;
    private String isbn;
    private String isbn13;
    private String languageCode;
    private int numPages;
    public int ratingsCount;
    private int textReviewsCount;
    public String publicationDate;
    private String publisher;

    public Libro(String bookId, String title, String authors, Float averageRating, String isbn, String isbn13,
            String languageCode, int numPages, int ratingsCount, int textReviewsCount,
            String publicationDate, String publisher) {

        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.averageRating = averageRating;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.languageCode = languageCode;
        this.numPages = numPages;
        this.ratingsCount = ratingsCount;
        this.textReviewsCount = textReviewsCount;
        this.publicationDate = publicationDate;
        this.publisher = publisher;

    }

    public int compareToAverageRating(Libro bookInstance) {
        if (averageRating > bookInstance.averageRating)
            return 1;
        if (averageRating < bookInstance.averageRating)
            return -1;
        return 0;
    }

    public int compareToAuthors(Libro bookInstance) {
        return authors.compareTo(bookInstance.authors);
    }

    public int compareToRatingsCount(Libro bookInstance) {
        if (ratingsCount > bookInstance.ratingsCount)
            return 1;
        if (ratingsCount < bookInstance.ratingsCount)
            return -1;
        return 0;
    }

    public int compareToPublicationDate(Libro bookInstance) {
        String[] date1 = publicationDate.split("/");
        String[] date2 = bookInstance.publicationDate.split("/");

        if (Integer.parseInt(date1[2]) != Integer.parseInt(date2[2]))
            return Integer.parseInt(date1[2]) - Integer.parseInt(date2[2]);

        if (Integer.parseInt(date1[0]) != Integer.parseInt(date2[0]))

            return Integer.parseInt(date1[0]) - Integer.parseInt(date2[0]);

        return Integer.parseInt(date1[1]) - Integer.parseInt(date2[1]);
    }

    public static class publicationDateComparator implements Comparator<Libro> {

        @Override
        public int compare(Libro x, Libro y) {
            if (x.compareToPublicationDate(y) > 0)
                return 1;
            if (x.compareToPublicationDate(y) < 0)
                return -1;
            return 0;
        }
    }

    public static class AuthorsComparator implements Comparator<Libro> {

        @Override
        public int compare(Libro x, Libro y) {
            if (x.compareToAuthors(y) > 0)
                return 1;
            if (x.compareToAuthors(y) < 0)
                return -1;
            return 0;
        }
    }

    public static class RatingsCountComparator implements Comparator<Libro> {

        @Override
        public int compare(Libro x, Libro y) {
            if (x.compareToRatingsCount(y) > 0)
                return 1;
            if (x.compareToRatingsCount(y) < 0)
                return -1;
            return 0;
        }
    }

    public static class averageRatingComparator implements Comparator<Libro> {

        @Override
        public int compare(Libro x, Libro y) {
            if (x.compareToAverageRating(y) > 0)
                return 1;
            if (x.compareToAverageRating(y) < 0)
                return -1;
            return 0;
        }

    }

    public static void listarPorComparador(Libro[] x, Comparator<Libro> comparador) {
        Insertion.sort(x, comparador);
        for (Libro libro : x) {
            StdOut.println(libro.toString());
        }
    }

    public static double medirTiempoSelectionSort(Libro[] librito, Comparator<Libro> comparator) {
        double empezarTiempo = System.nanoTime();
        Selection.sort(librito, comparator);
        double terminarTiempo = System.nanoTime() - empezarTiempo;
        return terminarTiempo * Math.pow(10, -9); // lo pasamos a seg
    }

    public static double medirTiempoArraysSort(Libro[] librito, Comparator<Libro> comparator) {
        double empezarTiempo = System.nanoTime();
        Arrays.sort(librito, comparator);
        double terminarTiempo = System.nanoTime() - empezarTiempo;
        return terminarTiempo * Math.pow(10, -9); // lo pasamos a seg
    }

    public static double medirTiempoInsertionSort(Libro[] librito, Comparator<Libro> comparator) {
        double empezarTiempo = System.nanoTime();
        Insertion.sort(librito, comparator);
        double terminarTiempo = System.nanoTime() - empezarTiempo;
        return terminarTiempo * Math.pow(10, -9); // lo pasamos a seg
    }

    public static double medirTiempoShellSort(Libro[] librito, Comparator<Libro> comparator) {
        double empezarTiempo = System.nanoTime();
        shellSort(librito, comparator);
        double terminarTiempo = System.nanoTime() - empezarTiempo;
        return terminarTiempo * Math.pow(10, -9); // lo pasamos a seg
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

    public static void shellSort(Object[] libros, Comparator<Libro> comparador) {
        int n = libros.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;
        while (h >= 1) {

            for (int i = h; i < n; i++) {
                Object temp = libros[i];
                int j = i;
                for (int k = i; j >= h && comparador.compare((Libro) temp, (Libro) libros[k - h]) < 0; k -= h) {
                    libros[j] = libros[k - h];
                    j -= h;
                }
                libros[j] = temp;
            }
            h /= 3;
        }
    }

    @Override
    public String toString() {

        String returnText = "BOOK ID: " + bookId + "\n" + "TITLE: " + title + "\n" + "AUTHORS: " + authors + "\n"
                + "AVERAGE RATING: " + averageRating + "\n" +
                "ISBN: " + isbn + "\n" + "ISBN13: " + isbn13 + "\n" + "LANGUAGE CODE: " + languageCode + "\n"
                + "PAGES: " + numPages + "\n" +
                "RATINGS COUNT: " + ratingsCount + "\n" + "TEXT REVIEWS COUNT: " + textReviewsCount + "\n"
                + "PUBLICACION DATE: " + publicationDate + "\n" + "PUBLISHER: " + publisher + "\n";
        ;
        return returnText;
    }

}