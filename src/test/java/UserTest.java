import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        user = new User("Test User");
        book1 = new Book("Book Title 1", "Author 1");
        book2 = new Book("Book Title 2", "Author 2");
    }

    @Test
    public void testUserInitialization() {
        assertEquals("Test User", user.getName());
        assertTrue(user.getBorrowedBooks().isEmpty());
    }

    @Test
    public void testBorrowBook() {
        user.borrowBook(book1);
        assertTrue(book1.isBorrowed());
        assertEquals(1, user.getBorrowedBooks().size());
        assertTrue(user.getBorrowedBooks().contains(book1));
    }

    @Test
    public void testReturnBook() {
        user.borrowBook(book1);
        user.returnBook(book1);
        assertFalse(book1.isBorrowed());
        assertTrue(user.getBorrowedBooks().isEmpty());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        user.borrowBook(book1);
        assertThrows(IllegalStateException.class, () -> user.borrowBook(book1), "Book is already borrowed");
    }

    @Test
    public void testReturnNonBorrowedBook() {
        assertThrows(IllegalStateException.class, () -> user.returnBook(book2), "This book was not borrowed by the user");
    }
}
