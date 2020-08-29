package ro.jademy.library.model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean isAdmin;
    public ArrayList<Book> bookList = new ArrayList<>();

    public User(String firstName, String lastName, String username, String password) {      //normal users
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String username, String password, boolean isAdmin) {    // admins
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.isAdmin=isAdmin;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName() { return lastName; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void printBorrowedBooks () {
        for (Book book : bookList) {
            String formattedDate = book.getReturnDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println("Title: "+book.getTitle()+ " Author: "+ book.getAuthor()+ " "+ formattedDate);
        }
    }
}
