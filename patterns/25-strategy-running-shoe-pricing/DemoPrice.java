import java.math.BigDecimal;
import java.math.RoundingMode;

public class DemoPrice implements PricingStrategy {
    public BigDecimal price(BigDecimal listPrice) {
        return listPrice.multiply(new BigDecimal("0.85")).setScale(2, RoundingMode.HALF_UP);
    }
    public String getCondition() { return "Demo (15% off)"; }
}
