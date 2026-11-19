public final class ExpiredView implements LibraryObserver {
    private final FineCalculator fineCalculator;

    public ExpiredView(FineCalculator fineCalculator) {
        this.fineCalculator = fineCalculator;
    }

    @Override
    public void update(Bookstore bookstore) {
        System.out.println("EXPIRED:");
        for (LendingAccount account : bookstore.getAccounts()) {
            for (BookLoan loan : account.getLoans()) {
                if (loan.getDueDate().isBefore(bookstore.getCurrentDate())) {
                    long daysOverdue = java.time.temporal.ChronoUnit.DAYS.between(
                            loan.getDueDate(), bookstore.getCurrentDate());
                    double fine = fineCalculator.calculate(loan.getDueDate(), bookstore.getCurrentDate());
                    System.out.printf("  %s: %s (%d days overdue, R%.2f)%n",
                            account.getAccountName(), loan.getBookTitle(), daysOverdue, fine);
                }
            }
        }
    }
}
