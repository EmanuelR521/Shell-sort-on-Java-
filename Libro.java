package upb.Taller33.TALLER3;

import java.util.*;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

public class Libro {

    private String bookId;
    private String title;
    private String authors;
    private Float averageRating;
    private String isbn;
    private String isbn13;
    private String languageCode;
    private int numPages;
    private int ratingsCount;
    private int textReviewsCount;
    private String publicationDate;
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
        String[] date2 = publicationDate.split("/");

        if (Integer.parseInt(date1[2]) != Integer.parseInt(date2[2])) return Integer.parseInt(date1[2]) - Integer.parseInt(date2[2]);

        if (Integer.parseInt(date1[1]) != Integer.parseInt(date2[1]))
        
            return Integer.parseInt(date1[1]) - Integer.parseInt(date2[1]);

        return Integer.parseInt(date1[0]) - Integer.parseInt(date2[0]);
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

    public static void listarPorComparador(Libro [] x, Comparator<Libro> comparador){
        Insertion.sort(x,comparador);
        for (Libro libro : x) {
            StdOut.println(libro.toString());
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