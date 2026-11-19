import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Bookstore {
    private LocalDate currentDate;
    private final List<LendingAccount> accounts = new ArrayList<LendingAccount>();
    private final List<LibraryObserver> observers = new ArrayList<LibraryObserver>();

    public Bookstore(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void addAccount(LendingAccount account) {
        accounts.add(account);
    }

    public List<LendingAccount> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void subscribe(LibraryObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(LibraryObserver observer) {
        observers.remove(observer);
    }

    public void advanceDate(int days) {
        currentDate = currentDate.plusDays(days);
        System.out.println("LIBRARY DATE: " + currentDate);
        for (LibraryObserver observer : new ArrayList<LibraryObserver>(observers)) {
            observer.update(this);
        }
    }
}
