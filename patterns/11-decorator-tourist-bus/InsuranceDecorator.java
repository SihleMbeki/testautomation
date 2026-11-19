public final class InsuranceDecorator extends TicketDecorator {
    public InsuranceDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return getTicket().getDescription() + " + insurance";
    }

    @Override
    public double getPrice() {
        return getTicket().getPrice() + 15;
    }
}
