package library.manager;

/**
 * 
 * Book's information
 * 
 * @author Luan N Nguyen
 *
 */
public class Book {
    /** Book's ID */
    private String id;

    /** Book's title */
    private String title;

    /** Book's author */
    private String author;

    /** Book's status if being borrowed or not */
    private boolean isBorrowed = false;

    /**
     * 
     * Constructor
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
    public Book(String id, String title, String author, boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    /**
     * Set book's ID
     * 
     * @param id
     *               Book's ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get book's ID
     * 
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Set book's title
     * 
     * @param title
     *                  Book's title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set book's title
     * 
     * @return book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set book's author
     * 
     * @param author
     *                   Book's author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get book's author
     * 
     * @return book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set book's status
     * 
     * @param isBorrowed
     *                       Book's status true or false
     */
    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    /**
     * Get book's status
     * 
     * @return book's status
     */
    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    /**
     * Format for printing book's information
     */
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20b", id, title, author, isBorrowed);
    }
}
