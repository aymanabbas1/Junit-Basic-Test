public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        if (isBorrowed) {
            throw new IllegalStateException("Book is already borrowed");
        }
        isBorrowed = true;
    }

    public void returnBook() {
        if (!isBorrowed) {
            throw new IllegalStateException("Book is not borrowed");
        }
        isBorrowed = false;
    }
}
