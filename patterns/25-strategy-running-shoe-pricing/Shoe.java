import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Shoe {
    private final String model;
    private final BigDecimal listPrice;
    private final PricingStrategy pricing;

    public Shoe(String model, BigDecimal listPrice, PricingStrategy pricing) {
        this.model = model;
        this.listPrice = listPrice;
        this.pricing = pricing;
    }
    public String displayPrice() {
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return model + " — " + pricing.getCondition() + ": R " + format.format(pricing.price(listPrice));
    }
}
