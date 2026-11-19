public class Main {
    public static void main(String[] args) {
        System.out.println("NETFLIX subscription payments");
        CardPayment debit = new DebitCardPayment("Ava", 500);
        CardPayment credit = new CreditCardPayment("Noah", 1000, 100);
        debit.pay(100);
        credit.pay(100);
    }
}
