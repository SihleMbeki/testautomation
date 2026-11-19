public abstract class FoodOrder {
    public final void placeOrder() {
        confirmAddress();
        applyVoucher();
        takePayment();
        fulfilOrder();
    }

    private void confirmAddress() { System.out.println("Address confirmed."); }
    private void applyVoucher() { System.out.println("Voucher applied."); }
    private void takePayment() { System.out.println("Payment taken."); }
    protected abstract void fulfilOrder();
}
