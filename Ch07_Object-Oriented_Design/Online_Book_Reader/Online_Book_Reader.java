import java.util.HashMap;
import java.util.UUID;

/**
 * Object-oriented design for an online book reader.
 * 
 * @author Gillis Werrebrouck
 */

public class Online_Book_Reader {
    public static void main(final String args[]) {}
}

abstract class Person {
    protected String firstName;
    protected String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class Author extends Person {
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

enum Genre {
    Action,
    Adventure,
    ComicBook,
    Crime,
    Drama,
    Fantasy,
    Horror,
    ScienceFiction,
}

class Book {
    private UUID id;
    private String title;
    private Author author;
    private Genre genre;
    private int publishingDate;
    private int pages;
    private String content;

    public Book(String title, Author author, Genre genre, int publishingDate, int pages, String content) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishingDate = publishingDate;
        this.pages = pages;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getPublishingDate() {
        return publishingDate;
    }

    public int getPages() {
        return pages;
    }

    public String getContent() {
        return content;
    }
}

class User extends Person {
    private UUID id;
    private boolean isMember;

    public User(String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean isMember) {
        this.isMember = isMember;
    }
}

class Library {
    private HashMap<UUID, Book> books = new HashMap<UUID, Book>();

    public Library() {}

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public boolean removeBook(UUID id) {
        if (books.containsKey(id)) {
            books.remove(id);
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book) {
        return this.removeBook(book.getId());
    }

    public Book getBook(UUID id) {
        return books.get(id);
    }
}

class UserManager {
    private HashMap<UUID, User> users = new HashMap<UUID, User>();

    public UserManager() {}

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getId());
    }

    public User getUser(UUID id) {
        return users.get(id);
    }
}

class Display {
    private Book currentBook;
    private User activeUser;
    private int pageNumber = 0;

    public Display() {}

    public Book getCurrentBook() {
        return currentBook;
    }
    
    public void setCurrentBook(Book currentBook) {
        this.currentBook = currentBook;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void nextPage() {
        if (this.pageNumber < this.currentBook.getPages()) {
            this.pageNumber++;
        }
    }

    public void previousPage() {
        if (0 < this.pageNumber) {
            this.pageNumber--;
        }
    }
}

class OnlineBookReader {
    Library library = new Library();
    UserManager userManager = new UserManager();
    Display display = new Display();

    public OnlineBookReader() {}

    public Library getLibrary() {
        return library;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Display getDisplay() {
        return display;
    }
}
