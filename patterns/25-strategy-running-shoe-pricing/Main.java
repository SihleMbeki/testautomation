import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Shoe[] shoes = {
            new Shoe("Swift", new BigDecimal("1000.00"), new FullPrice()),
            new Shoe("Pace", new BigDecimal("1200.00"), new FullPrice()),
            new Shoe("Swift", new BigDecimal("1000.00"), new DemoPrice()),
            new Shoe("Pace", new BigDecimal("1200.00"), new DemoPrice()),
            new Shoe("Swift", new BigDecimal("1000.00"), new SecondHandPrice()),
            new Shoe("Pace", new BigDecimal("1200.00"), new SecondHandPrice())
        };
        for (Shoe shoe : shoes) System.out.println(shoe.displayPrice());
    }
}
