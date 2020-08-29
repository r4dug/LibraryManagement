package ro.jademy.library;

import ro.jademy.library.model.Book;
import ro.jademy.library.model.Shelf;
import ro.jademy.library.model.User;
import ro.jademy.library.model.Library;


public class Main {

    public static void main(String[] args) {


        Library library1 = initLibrary();
        library1.showGreeting();
        library1.showLogin();
        library1.showMenu();

    }
    public static Library initLibrary() {

        Book book1 = new Book("Dune", "Frank Herbert", 80, "9780593099322", 688, "SF");
        Book book2 = new Book("Slaughter House 5", "Kurt Vonnegut", 100, "9780385333849", 275, "Classic");
        Book book3 = new Book("1984", "George Orwell", 75, "BOO3JTHWKU", 237, "Classic");

        Shelf shelf1 = new Shelf("SF");
        Shelf shelf2 = new Shelf("Classic");

        shelf1.bookList.add(book1);
        shelf2.bookList.add(book2);
        shelf2.bookList.add(book3);

        User user1 = new User("Gigi", "Gigescu", "gigi.gigescu", "1234");

        Library library = new Library();
        library.shelfList.add(shelf1);
        library.shelfList.add(shelf2);
        library.userList.add(user1);

        return library;
    }

}
