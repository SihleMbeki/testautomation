public class Account {
    private final String correctPassword;
    private int failedAttempts;
    private AccountState state = new ActiveState();

    public Account(String correctPassword) { this.correctPassword = correctPassword; }
    public void login(String password) { state.login(this, password); }
    boolean passwordMatches(String password) { return correctPassword.equals(password); }
    int getFailedAttempts() { return failedAttempts; }
    void recordFailure() { failedAttempts++; }
    void resetFailures() { failedAttempts = 0; }
    void setState(AccountState state) { this.state = state; }
}
