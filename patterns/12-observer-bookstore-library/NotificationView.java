import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class NotificationView implements LibraryObserver {
    @Override
    public void update(Bookstore bookstore) {
        LocalDate today = bookstore.getCurrentDate();
        LocalDate threshold = today.plusDays(3);
        System.out.println("REMINDERS:");
        for (LendingAccount account : bookstore.getAccounts()) {
            for (BookLoan loan : account.getLoans()) {
                if (!loan.getDueDate().isAfter(threshold)) {
                    if (loan.getDueDate().isBefore(today)) {
                        long daysOverdue = ChronoUnit.DAYS.between(loan.getDueDate(), today);
                        System.out.printf("  %s: %s (%d days overdue)%n",
                                account.getAccountName(), loan.getBookTitle(), daysOverdue);
                    } else {
                        System.out.printf("  %s: %s due %s%n",
                                account.getAccountName(), loan.getBookTitle(), loan.getDueDate());
                    }
                }
            }
        }
    }
}
