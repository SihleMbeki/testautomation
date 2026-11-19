public class EftPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.printf("EFT payment R%.2f fee R%.2f%n", amount, 2.5); }
}
