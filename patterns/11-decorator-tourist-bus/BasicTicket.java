public final class BasicTicket implements Ticket {
    @Override
    public String getDescription() {
        return "Basic entry";
    }

    @Override
    public double getPrice() {
        return 150;
    }
}
