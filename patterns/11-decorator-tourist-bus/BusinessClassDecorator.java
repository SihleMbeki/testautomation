public final class BusinessClassDecorator extends TicketDecorator {
    public BusinessClassDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return getTicket().getDescription() + " + business class";
    }

    @Override
    public double getPrice() {
        return getTicket().getPrice() + 10;
    }
}
