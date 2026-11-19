public final class CreditCardPayment extends CardPayment {
    private final double creditLimit;
    private double currentDebt;
    private static final double PROCESSING_RATE = 0.02;

    public CreditCardPayment(String cardholder, double creditLimit, double currentDebt) {
        super(cardholder);
        this.creditLimit = creditLimit;
        this.currentDebt = currentDebt;
    }

    @Override
    protected boolean hasCapacity(double purchaseAmount) {
        double total = amountToCharge(purchaseAmount);
        System.out.printf("CHECK credit available R%.2f%n", creditLimit - currentDebt);
        return currentDebt + total <= creditLimit;
    }

    @Override
    protected double amountToCharge(double purchaseAmount) {
        return purchaseAmount * (1 + PROCESSING_RATE);
    }

    @Override
    protected void charge(double amount) {
        currentDebt += amount;
        System.out.printf("CREDIT charged R%.2f (includes 2%% fee); debt R%.2f%n", amount, currentDebt);
    }

    @Override
    protected String paymentName() {
        return "credit";
    }
}
