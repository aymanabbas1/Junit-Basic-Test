import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new IllegalArgumentException("Book not found");
    }

    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new IllegalArgumentException("User not found");
    }
}
