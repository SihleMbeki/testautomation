import java.time.LocalDate;

public final class BookLoan {
    private final String bookTitle;
    private final LocalDate dueDate;

    public BookLoan(String bookTitle, LocalDate dueDate) {
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
