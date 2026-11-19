public final class DebitCardPayment extends CardPayment {
    private double balance;

    public DebitCardPayment(String cardholder, double balance) {
        super(cardholder);
        this.balance = balance;
    }

    @Override
    protected boolean hasCapacity(double purchaseAmount) {
        System.out.printf("CHECK debit balance R%.2f%n", balance);
        return balance >= purchaseAmount;
    }

    @Override
    protected double amountToCharge(double purchaseAmount) {
        return purchaseAmount;
    }

    @Override
    protected void charge(double amount) {
        balance -= amount;
        System.out.printf("DEBIT charged R%.2f; balance R%.2f%n", amount, balance);
    }

    @Override
    protected String paymentName() {
        return "debit";
    }
}
