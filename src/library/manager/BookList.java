package library.manager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create book's activities
 * 
 * @author Luan N Nguyen
 *
 */
public class BookList {

    /** Create books list array */
    ArrayList<Book> myBooks = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    /**
     * Import books to library
     */
    public void add() {
        boolean checkID = true;

        System.out.println("Enter information for the new book:");

        System.out.print("ID: ");
        String id = sc.nextLine();

        do {
            for (int i = 0; i < myBooks.size(); i++) {
                if (myBooks.get(i).getId().contains(id)) {
                    System.out.println("This ID has been exist - Try again!");
                    checkID = false;
                    System.out.print("ID: ");
                    id = sc.nextLine();
                    break;
                } else {
                    checkID = true;
                }
            }
        } while (checkID == false);

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Is borrowed (1 = yes, 0 = no): ");

        // User chooses 1 if book's borrowed and 0 if not
        int choice = InputHelper.inputVal(sc, 0, 1);

        boolean isBorrowed = false;

        switch (choice) {
        case 1:
            isBorrowed = true;
            break;

        case 0:
        default:
            isBorrowed = false;
            break;
        }

        addToList(id.toUpperCase(), title, author, isBorrowed);
        System.out.println("A new book has been added!");
        System.out.println("**********************************");
        System.out.println();
    }

    /**
     * 
     * Import new book to books list array
     * 
     * @param id
     *                       Book's ID
     * @param title
     *                       Book's title
     * @param author
     *                       Book's author
     * @param isBorrowed
     *                       Book's status
     */
    public void addToList(String id, String title, String author, boolean isBorrowed) {
        // Create book object and its information
        Book book = new Book(id.toUpperCase(), title, author, isBorrowed);

        myBooks.add(book);
    }

    /**
     * Search book's in library
     */
    public void search() {
        // Create books searching list
        ArrayList<Book> booksFound = new ArrayList<>();

        System.out.println("Enter book title to search.");
        System.out.print("Book title: ");
        String searchKey = sc.nextLine();
        for (Book book : myBooks) {
            // If the title that user type is correct with any book titles, import that book to the books searching list
            if (book.getTitle().toLowerCase().contains(searchKey.toLowerCase())) {
                booksFound.add(book);
            }
        }
        if (booksFound.isEmpty()) {
            System.out.println("No book is found!");
        } else {
            System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borowed"));
            // Using loop to print items from books searching list
            for (Book book : booksFound) {
                System.out.println(book.toString());
            }
        }
        System.out.println("**********************************");
        System.out.println();
    }

    /**
     * Display books in books list array
     */
    public void display() {
        System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borowed"));
        for (Book book : myBooks) {
            System.out.println(book.toString());
        }
        System.out.println("**********************************");
        System.out.println();
    }

    /**
     * Borrow a book in books list array
     */
    public void borrow() {
        System.out.println("Enter a book ID to borrow:");
        System.out.print("Book ID: ");
        String searchKey = sc.nextLine();

        for (Book book : myBooks) {
            if (book.getId().equalsIgnoreCase(searchKey)) {
                if (book.getIsBorrowed()) {
                    System.out.println("You cannot borrow this book because it has been borrowed!");
                } else {
                    book.setIsBorrowed(true);
                    System.out.println("You have succesfully borrow the book: " + book.getTitle());
                }
                System.out.println("**********************************");
                System.out.println();
                return;
            }
        }
        System.out.println("This item doesn't exist!");
        System.out.println("**********************************");
        System.out.println();
    }

    /**
     * Exit program
     */
    public void exit() {
        System.out.println("END!!!");
        System.out.println("**********************************");
        System.exit(0);
    }
}
