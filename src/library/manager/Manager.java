package library.manager;

import java.util.Scanner;

/**
 * 
 * Main class
 * 
 * @author Luan N Nguyen
 * @since February 01st 2021
 * @version 1.0
 *
 */
public class Manager {

    public static Scanner sc;

    /**
     * 
     * Main method for program
     */
    public static void main(String[] args) {

        // Create new BookList object from BookList class
        BookList bookListObj = new BookList();

        sc = new Scanner(System.in);

        // Variable for user to choose in 5 options (from 1 to 5)
        int functionID;

        do {
            showMenu();
            functionID = InputHelper.inputVal(sc, 1, 5);

            switch (functionID) {
            case 1:
                bookListObj.add();
                break;
            case 2:
                bookListObj.search();
                break;
            case 3:
                bookListObj.display();
                break;
            case 4:
                bookListObj.borrow();
                break;
            case 5:
            default:
                bookListObj.exit();
                break;
            }
        } while (functionID != 5);

        sc.close();
    }

    /**
     * Show introducing menu
     */
    public static void showMenu() {
        System.out.println("Welcome to the online book library!");
        System.out.println("-----------------------------------");
        System.out.println("1. Enter a new book");
        System.out.println("2. Search a book by book title");
        System.out.println("3. Display books");
        System.out.println("4. Borrow a book by book ID");
        System.out.println("5. Exit");
        System.out.print("Your choice [1 - 5]: ");
    }
}