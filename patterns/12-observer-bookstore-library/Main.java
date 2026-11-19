import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore(LocalDate.of(2026, 6, 1));
        LendingAccount account = new LendingAccount("Account 104");
        account.borrow(new BookLoan("The Long Way Home", LocalDate.of(2026, 6, 3)));
        bookstore.addAccount(account);

        bookstore.subscribe(new NotificationView());
        bookstore.subscribe(new ExpiredView(new DailyFineCalculator(2.50)));
        bookstore.advanceDate(0);
        bookstore.advanceDate(4);
    }
}
