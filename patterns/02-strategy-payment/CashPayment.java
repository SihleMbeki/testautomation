public class CashPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.printf("Cash payment R%.2f fee R%.2f%n", amount, 0.0); }
}
