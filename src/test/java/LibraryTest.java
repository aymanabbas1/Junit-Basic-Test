import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private User user1;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Book Title 1", "Author 1");
        book2 = new Book("Book Title 2", "Author 2");
        user1 = new User("User 1");

        library.addBook(book1);
        library.addBook(book2);
        library.addUser(user1);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("Book Title 3", "Author 3");
        library.addBook(book3);
        assertEquals(book3, library.findBookByTitle("Book Title 3"));
    }

    @Test
    public void testAddUser() {
        User user2 = new User("User 2");
        library.addUser(user2);
        assertEquals(user2, library.findUserByName("User 2"));
    }

    @Test
    public void testBorrowBook() {
        user1.borrowBook(book1);
        assertTrue(book1.isBorrowed());
        assertEquals(1, user1.getBorrowedBooks().size());
    }

    @Test
    public void testReturnBook() {
        user1.borrowBook(book1);
        user1.returnBook(book1);
        assertFalse(book1.isBorrowed());
        assertEquals(0, user1.getBorrowedBooks().size());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        user1.borrowBook(book1);
        assertThrows(IllegalStateException.class, () -> user1.borrowBook(book1), "Book is already borrowed");
    }

    @Test
    public void testReturnNonBorrowedBook() {
        assertThrows(IllegalStateException.class, () -> user1.returnBook(book2), "This book was not borrowed by the user");
    }
}
