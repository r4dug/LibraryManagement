package ro.jademy.library.model;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ro.jademy.library.model.Book;
import ro.jademy.library.model.Shelf;
import ro.jademy.library.model.User;
import ro.jademy.library.model.Library;


public class Library {

    public ArrayList<Shelf> shelfList = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();
    public static final int BORROW_MAX_TIME = 30;
    public static Scanner sc = new Scanner(System.in);


    public void showGreeting () {
        System.out.println("| ----------------------------------------- |");
        System.out.println("|       Welcome to the JaLibrary            |");
    }

    public boolean checkUser(String username, String password) {
        boolean check = false;
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                check = true;
            }
            else {
                System.out.println("Incorrect credentials. Please try again.");
            }
        }
        return check;
    }

    public void showLogin () {
        String username;
        String password;
        do {
            System.out.println("| ----------------------------------------- |");
            System.out.println("Username: ");
            username = sc.nextLine();
            System.out.println("Password: ");
            password = sc.nextLine();
        }

        while (!checkUser(username,password));
    }

    public void showMenu() {

        System.out.println("1. Show all existing books");
        System.out.println("2. Show book by genre");
        System.out.println("3. Show book by title");
        System.out.println("4. Show book by author");
        System.out.println("5. Show book by isbn");
        System.out.println("6. Borrow a book");
        System.out.println("7. Show user info");
        System.out.println("8. Logout");

        chooseAnOption();

    }

    public void chooseAnOption() {
        System.out.println("Choose an option");
        String optionSelected = sc.nextLine();
        switch (optionSelected) {
            case "1":
                listBooks();
                showMenu();
                break;

            case "2":
                System.out.println("What genre are you looking for?");
                String genreSearched = sc.nextLine();
                listBooks(genreSearched);
                showMenu();
                break;

            case "3":
                System.out.println("What's the name of the book?");
                String titleSearched = sc.nextLine();
                searchByTitle(titleSearched);
                showMenu();
                break;

            case "4":
                System.out.println("What's the name of the book's author?");
                String authorSearched = sc.nextLine();
                searchByAuthor(authorSearched);
                showMenu();
                break;

            case "5":
                System.out.println("Please enter the book's ISBN");
                String isbnSearched = sc.nextLine();
                searchByISBN(isbnSearched);
                showMenu();
                break;

            case "8":
                System.out.println("User has been successfully logged out.");
                showGreeting();
                showLogin();
                break;

            default:
                System.out.println("Choose a correct option.");
        }
    }


    public void listBooks () {

        //Genre: SF
        // - Dune, Frank Herbert (ISBN: 9780593099322) - Lei 1500
        //Genre: Classic
        // - Slaughter House 5, Kurt Vonnegut (ISBN:858239542905842) - Lei 3000
        //TODO
        for (Shelf shelf : shelfList) {
                System.out.println("Genre: " + shelf.genre);
                for (Book book : shelf.bookList) {
                    System.out.println("     " + book.getTitle() + ", " + book.getAuthor() + "  (ISBN: " + book.getIsbn() + ") - Lei " + book.getPrice());
                }
            }
        }


    public void listBooks(String genre) {

        //TODO : list all books by given genre

        for (Shelf shelf : shelfList) {
            if (genre.equals(shelf.genre)) {
                System.out.println("Genre: " + shelf.genre);
                for (Book book : shelf.bookList) {
                    System.out.println("     " + book.getTitle() + ", " + book.getAuthor() + "  (ISBN: " + book.getIsbn() + ") - Lei " + book.getPrice());
                }
            }
        }
    }

    public void addBook(Book book) {

        //TODO: add a book to the library
        //steps :
        //if a shelf with the same genre as the book exists, add the book to that shelf
        //else
        //create a new shelf with the same genre as the book
        //add the book to the shelf
        //add the shelf to the library
        //if (book.genre=shelf)

        if (isGenreInLibrary(book.getGenre())) {
            for (Shelf shelf : shelfList) {
                if (book.getGenre().equals(shelf.genre)) {
                    shelf.bookList.add(book);
                }
            }
        } else {
            Shelf shelf = new Shelf(book.getGenre());
            System.out.println(shelf);
            shelf.bookList.add(book);
            this.shelfList.add(shelf);
        }

    }

    public boolean isGenreInLibrary (String genre) {

        //TODO: check if there is a shelf with the given genre

        for (Shelf shelf : shelfList) {
            if (genre.equals(shelf.genre)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> searchByTitle (String title) {

        //TODO: return all the books with the given title
        //TODO: question: should it be the full title or just a part of it?

        ArrayList<Book> bookList = new ArrayList<>();
        for (Shelf shelf : shelfList) {
            for (Book book : shelf.bookList) {
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    bookList.add(book);
                    System.out.println("     " + book.getTitle() + ", " + book.getAuthor() + "  (ISBN: " + book.getIsbn() + ") - Lei " + book.getPrice());
                }
            }
        }

        return bookList;
    }

    public ArrayList<Book> searchByAuthor (String author) {

        //TODO: return all the books with the given author

        ArrayList<Book> bookList = new ArrayList<>();
        for (Shelf shelf : shelfList) {
            for (Book book : shelf.bookList) {
                if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    bookList.add(book);
                    System.out.println("     "+book.getAuthor()+" -> "+book.getTitle());
                }
            }
        }

        return bookList;
    }


    public Book searchByISBN (String isbn) { //o singura carte are isbn asa ca nu trebuie returnate mai multe

        //TODO: return a single book with the given isbn
        // question: what should we return when no book is found?
        ArrayList<Book> bookList = new ArrayList<>();

        for (Shelf shelf : shelfList) {
            for (Book book : shelf.bookList) {
                if (isbn.equals(book.getIsbn())) {
                    bookList.add(book);;
                    System.out.println("     " + book.getTitle() + ", " + book.getAuthor() + "  (ISBN: " + book.getIsbn() + ") - Lei " + book.getPrice());
                }
            }
        }
        System.out.println("That isbn doesn't exist!");
        return null;
    }

    public boolean borrowBook(Book book, User user) {
        //TODO: remove the book from the library shelf and add it to the list of borrowed books of the user
        //TODO: return true if the book was successfully borrowed

        for (Shelf shelf1 : shelfList) {
            for (Book book1 : shelf1.bookList) {
                if (book1.getIsbn().equals(book.getIsbn())) {
                    book1.setReturnDate(LocalDate.now().plusDays(BORROW_MAX_TIME));
                    user.bookList.add(book);
                    shelf1.bookList.remove(book);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean borrowBook (String isbn, User user) {

        //TODO: same as above, only check by ISBN

        for (Shelf shelf1 : shelfList) {
            for (Book book1: shelf1.bookList) {

            }
        }

        Book book = searchByISBN(isbn);
        return borrowBook(book, user);

    }

}
