public class Main {
    public static void main(String[] args) {
        System.out.println("STRATEGY - Payment methods (Rand)");
        new Checkout(new CardPayment()).checkout(250);
        new Checkout(new CashPayment()).checkout(250);
        new Checkout(new EftPayment()).checkout(250);
    }
}
