public class LockedAccountState implements AccountState {
    public void login(Account account, String password) {
        System.out.println("Account locked.");
    }
}
