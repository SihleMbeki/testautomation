public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketFactory singleBuyerFactory = new TicketFactory(new SafeEarlyBirdCounter());
        for (int buyer = 1; buyer <= 1002; buyer++) {
            Ticket ticket = singleBuyerFactory.buy();
            if (buyer >= 999) {
                System.out.println("Buyer " + buyer + ": race number "
                        + ticket.raceNumber() + ", free shirt "
                        + (ticket.hasFreeShirt() ? "yes" : "no"));
            }
        }

        int unsafeShirts = RaceDemo.unsafeShirtCount(20);
        System.out.println("Unsafe concurrent buyers at 1,000 boundary: "
                + unsafeShirts + " shirts (expected 1)");
        int safeShirts = RaceDemo.safeShirtCount(1100);
        System.out.println("Safe concurrent buyers: " + safeShirts
                + " shirts (expected 1000)");
    }
}
