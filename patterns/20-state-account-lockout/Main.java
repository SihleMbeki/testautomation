public class Main {
    public static void main(String[] args) {
        Account account = new Account("secret");
        account.login("wrong");
        account.login("wrong");
        account.login("wrong");
        account.login("secret");

        Account freshAccount = new Account("secret");
        freshAccount.login("wrong");
        freshAccount.login("secret");
    }
}
