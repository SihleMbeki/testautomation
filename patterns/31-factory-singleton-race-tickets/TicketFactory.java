public class TicketFactory {
    private final EarlyBirdCounter counter;

    public TicketFactory(EarlyBirdCounter counter) { this.counter = counter; }

    public Ticket buy() {
        int number = RaceOffice.INSTANCE.nextRaceNumber();
        return new Ticket(number, counter.claimShirt());
    }
}
