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

        int unsafeShirts = RaceDemo.unsafeTotalShirtCount(20);
        System.out.println("Unsafe total shirts: " + unsafeShirts
                + " (over the 1,000 limit; includes 999 earlier buyers)");
        int safeShirts = RaceDemo.safeShirtCount(1100);
        System.out.println("Safe concurrent buyers: " + safeShirts
                + " shirts (expected 1000)");
    }
}
