public final class VipDecorator extends TicketDecorator {
    public VipDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return getTicket().getDescription() + " + VIP";
    }

    @Override
    public double getPrice() {
        return getTicket().getPrice() + 30;
    }
}
