public final class LuggageDecorator extends TicketDecorator {
    public LuggageDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return getTicket().getDescription() + " + luggage";
    }

    @Override
    public double getPrice() {
        return getTicket().getPrice() + 20;
    }
}
