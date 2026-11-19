public class UnsafeTicketCounter {
    private static final UnsafeTicketCounter INSTANCE = new UnsafeTicketCounter();
    private int value;
    private UnsafeTicketCounter() { }
    public static UnsafeTicketCounter getInstance() { return INSTANCE; }
    public int nextTicket() {
        int observed = value;
        try { Thread.sleep(0, 100_000); } catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
        value = observed + 1;
        return value;
    }
    public void reset() { value = 0; }
}
