import java.math.BigDecimal;

public class Main {
    private static void printQuote(TicketFareCalculator calculator,
                                   String origin, String destination) {
        try {
            BigDecimal fare = calculator.quote(origin, destination);
            System.out.println(origin.trim() + " to " + destination.trim()
                    + ": R" + fare.toPlainString());
        } catch (IllegalArgumentException exception) {
            System.out.println("Cannot quote: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        TicketFareCalculator calculator = new TicketFareCalculator();
        if (args.length == 2) {
            printQuote(calculator, args[0], args[1]);
            return;
        }
        printQuote(calculator, " KZN ", "KwaZulu-Natal");
        printQuote(calculator, "KZN", "Gauteng");
        printQuote(calculator, "Atlantis", "Gauteng");
    }
}
