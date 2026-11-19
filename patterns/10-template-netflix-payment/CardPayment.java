public abstract class CardPayment {
    private final String cardholder;

    protected CardPayment(String cardholder) {
        this.cardholder = cardholder;
    }

    public final boolean pay(double purchaseAmount) {
        validate(purchaseAmount);
        if (cardholder == null || cardholder.trim().isEmpty()) {
            System.out.println("PAYMENT declined: invalid cardholder");
            return false;
        }
        if (!hasCapacity(purchaseAmount)) {
            System.out.println("PAYMENT declined: insufficient funds or limit");
            return false;
        }
        double chargedAmount = amountToCharge(purchaseAmount);
        charge(chargedAmount);
        System.out.printf("RECEIPT %s charged R%.2f%n", paymentName(), chargedAmount);
        return true;
    }

    private void validate(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        System.out.println("VALIDATE card for " + cardholder);
    }

    protected abstract boolean hasCapacity(double purchaseAmount);

    protected abstract double amountToCharge(double purchaseAmount);

    protected abstract void charge(double amount);

    protected abstract String paymentName();
}
