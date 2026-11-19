public abstract class TicketDecorator implements Ticket {
    private final Ticket ticket;

    protected TicketDecorator(Ticket ticket) {
        this.ticket = ticket;
    }

    protected Ticket getTicket() {
        return ticket;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription();
    }

    @Override
    public double getPrice() {
        return ticket.getPrice();
    }
}
