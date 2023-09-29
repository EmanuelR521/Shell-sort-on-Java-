package upb.Taller33.TALLER3;
import java.util.*;

public class Libro implements Comparable<Libro> {

    private String bookId;
    private String title;
    private String Authors;
    public Float averageRating;
    private String isbn;
    private String isbn13;
    private String languageCode;
    private int numPages;
    private int ratingsCount;
    private int textReviewsCount;
    private String publicationDate;
    private String publisher;
    public Libro(){

    }
    public Libro(String bookId, String title, String Authors, Float averageRating, String isbn, String isbn13,
            String languageCode, int numPages, int ratingsCount, int textReviewsCount,
            String publicationDate, String publisher) {

        this.bookId = bookId;
        this.title = title;
        this.Authors = Authors;
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
        if (averageRating != bookInstance.averageRating) return (int)(averageRating-bookInstance.averageRating);
        return 0;
    }
    
public class FechaComparator  implements Comparator<Libro>{
    
    @Override
    public int compare(Libro x, Libro y){
        if(x.compareTo(y)>0) return 1;
        if(x.compareTo(y)<0) return -1;
        return 0;
    }
        // Pruebas unitarias del Comparator de Fecha
    public static void main(String[] args){}
    
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