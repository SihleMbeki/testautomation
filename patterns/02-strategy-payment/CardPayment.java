public class CardPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.printf("Card payment R%.2f fee R%.2f%n", amount, 5.0); }
}
