public class TicketCounter {
    private static final TicketCounter INSTANCE = new TicketCounter();
    private int value;
    private TicketCounter() { }
    public static TicketCounter getInstance() { return INSTANCE; }
    public synchronized int nextTicket() {
        int observed = value;
        try { Thread.sleep(0, 100_000); } catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
        value = observed + 1;
        return value;
    }
    public synchronized void reset() { value = 0; }
}
