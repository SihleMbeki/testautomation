public class Naive {
    public static void main(String[] args) {
        double debitBalance = 500;
        double debitPurchase = 100;
        // Duplicated workflow means fixes to validation, charging, or receipts must be repeated.
        if (debitPurchase > 0 && debitBalance >= debitPurchase) {
            debitBalance -= debitPurchase;
            System.out.printf("NAIVE debit charged R%.2f%n", debitPurchase);
            System.out.println("NAIVE debit receipt issued");
        }

        double creditLimit = 1000;
        double currentDebt = 100;
        double creditPurchase = 100;
        double fee = creditPurchase * 0.02;
        if (creditPurchase > 0 && currentDebt + creditPurchase + fee <= creditLimit) {
            currentDebt += creditPurchase + fee;
            System.out.printf("NAIVE credit charged R%.2f%n", creditPurchase + fee);
            System.out.println("NAIVE credit receipt issued");
        }
    }
}
