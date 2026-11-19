public class Main {
    private static void printTicket(Ticket ticket) {
        System.out.printf("%s = R%.2f%n", ticket.getDescription(), ticket.getPrice());
    }

    public static void main(String[] args) {
        Ticket extras = new BasicTicket();
        extras = new MealDecorator(extras);
        extras = new MealDecorator(extras);
        extras = new InsuranceDecorator(extras);
        printTicket(extras);
        printTicket(new BusinessClassDecorator(new BasicTicket()));
        printTicket(new VipDecorator(new BasicTicket()));
        printTicket(new LuggageDecorator(new LuggageDecorator(new BasicTicket())));
    }
}
