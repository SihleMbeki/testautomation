import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Naive {
    public static void main(String[] args) {
        String[] models = { "Swift", "Pace", "Swift", "Pace", "Swift", "Pace" };
        BigDecimal[] prices = {
            new BigDecimal("1000.00"), new BigDecimal("1200.00"),
            new BigDecimal("1000.00"), new BigDecimal("1200.00"),
            new BigDecimal("1000.00"), new BigDecimal("1200.00")
        };
        String[] conditions = { "Full price", "Full price", "Demo", "Demo", "Second hand", "Second hand" };
        // Growing conditionals must be changed everywhere that computes a shoe price.
        for (int i = 0; i < models.length; i++) {
            BigDecimal amount;
            if ("Demo".equals(conditions[i])) amount = prices[i].multiply(new BigDecimal("0.85"));
            else if ("Second hand".equals(conditions[i])) amount = prices[i].multiply(new BigDecimal("0.60"));
            else amount = prices[i];
            NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(2);
            String label = "Demo".equals(conditions[i]) ? "Demo (15% off)"
                    : "Second hand".equals(conditions[i]) ? "Second hand (40% off)" : "Full price";
            System.out.println(models[i] + " — " + label + ": R " + format.format(amount));
        }
    }
}
