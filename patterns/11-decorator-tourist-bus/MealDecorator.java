public final class MealDecorator extends TicketDecorator {
    public MealDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return getTicket().getDescription() + " + meal";
    }

    @Override
    public double getPrice() {
        return getTicket().getPrice() + 25;
    }
}
