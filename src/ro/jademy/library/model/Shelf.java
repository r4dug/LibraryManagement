package ro.jademy.library.model;

import java.util.ArrayList;

public class Shelf {

    public String genre;
    public ArrayList<Book> bookList = new ArrayList<>();

    public Shelf(String genre) {
        this.genre = genre;
    }
}
