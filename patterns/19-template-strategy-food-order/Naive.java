public class Naive {
    public static void main(String[] args) {
        boolean delivery = true;
        // Repeating this fixed workflow for each fulfilment option invites drift.
        System.out.println("Address confirmed.");
        System.out.println("Voucher applied.");
        System.out.println("Payment taken.");
        if (delivery) System.out.println("Order delivered; customer enters delivery PIN.");
        else System.out.println("Order ready for later store collection.");
        delivery = false;
        System.out.println("Address confirmed.");
        System.out.println("Voucher applied.");
        System.out.println("Payment taken.");
        if (delivery) System.out.println("Order delivered; customer enters delivery PIN.");
        else System.out.println("Order ready for later store collection.");
    }
}
