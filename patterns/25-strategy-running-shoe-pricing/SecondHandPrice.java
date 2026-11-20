import java.math.BigDecimal;
import java.math.RoundingMode;

public class SecondHandPrice implements PricingStrategy {
    public BigDecimal price(BigDecimal listPrice) {
        return listPrice.multiply(new BigDecimal("0.60")).setScale(2, RoundingMode.HALF_UP);
    }
    public String getCondition() { return "Second hand (40% off)"; }
}
