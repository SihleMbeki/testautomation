public class ActiveState implements AccountState {
    public void login(Account account, String password) {
        if (account.passwordMatches(password)) {
            account.resetFailures();
            System.out.println("Login successful; failed-attempt counter reset.");
            return;
        }
        account.recordFailure();
        int remaining = 3 - account.getFailedAttempts();
        if (remaining == 0) {
            account.setState(new LockedAccountState());
            System.out.println("Login failed; account locked.");
        } else {
            System.out.println("Login failed; " + remaining + " attempts remaining.");
        }
    }
}
