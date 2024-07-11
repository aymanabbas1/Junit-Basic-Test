import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("Test Title", "Test Author");
    }

    @Test
    public void testBookInitialization() {
        assertEquals("Tst Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testBorrowBook() {
        book.borrow();
        assertTrue(book.isBorrowed());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        book.borrow();
        assertThrows(IllegalStateException.class, book::borrow, "Book is already borrowed");
    }

    @Test
    public void testReturnBook() {
        book.borrow();
        book.returnBook();
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testReturnNonBorrowedBook() {
        assertThrows(IllegalStateException.class, book::returnBook, "Book is not borrowed");
    }
}
