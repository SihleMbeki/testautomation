import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LendingAccount {
    private final String accountName;
    private final List<BookLoan> loans = new ArrayList<BookLoan>();

    public LendingAccount(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void borrow(BookLoan loan) {
        loans.add(loan);
    }

    public List<BookLoan> getLoans() {
        return Collections.unmodifiableList(loans);
    }
}
