package upb.Taller33.TALLER3;

import java.util.*;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Libro implements Comparable<Libro> {

    private String bookId;
    private String title;
    private String authors;
    public Float averageRating;
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

    public int compareTo(Libro bookInstance) {
        if (averageRating > bookInstance.averageRating) return 1;
        if (averageRating < bookInstance.averageRating) return -1;
        return 0;
    }

    public int compareTo(Libro bookInstance) {
        if (authors > bookInstance.authors) return 1;
        if (averageRating < bookInstance.averageRating) return -1;
        return 0;
    }



    public static class authorComparator implements  {

        @Override
        public int compare(Libro x, Libro y) {
            if (x.compareTo(y) > 0)
                return 1;
            if (x.compareTo(y) < 0)
                return -1;
            return 0;
        }

    }

    public class averageRatingComparator implements Comparator<Libro>{
        public int compare(Libro x, Libro y);
    }

    @Override
    public String toString() {
        String returnText = "BOOK ID: " + bookId + "\n" + "TITLE: " + title + "\n" + "AUTHORS: " + Authors + "\n"
                + "AVERAGE RATING: " + averageRating + "\n" +
                "ISBN: " + isbn + "\n" + "ISBN13: " + isbn13 + "\n" + "LANGUAGE CODE: " + languageCode + "\n"
                + "PAGES: " + numPages + "\n" +
                "RATINGS COUNT: " + ratingsCount + "\n" + "TEXT REVIEWS COUNT: " + textReviewsCount + "\n"
                + "PUBLICACION DATE: " + publicationDate + "\n" + "PUBLISHER: " + publisher + "\n";
        ;
        return returnText;
    }


}