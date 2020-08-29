package ro.jademy.library.model;

import java.time.LocalDate;

public class Book {

    private String title;
    private String author;
    private long price;
    private String isbn;
    private int numberOfPages;
    private String genre;
    public LocalDate returnDate;

    public Book(String title, String author, long price, String isbn, int numberOfPages, String genre) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {return author;}

    public long getPrice () { return price;}

    public String getIsbn() { return isbn; }

    public int getNumberOfPages() { return numberOfPages; }

    public String getGenre() { return genre; }

    public LocalDate getReturnDate () { return returnDate;}

    // not need for title&author&isbn setters

    public void setPrice(long price) { this.price=price; }

    public void setReturnDate(LocalDate returnDate) {this.returnDate=returnDate;}


}
