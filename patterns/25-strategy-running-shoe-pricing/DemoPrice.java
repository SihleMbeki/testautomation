import java.math.BigDecimal;

public class DemoPrice implements PricingStrategy {
    public BigDecimal price(BigDecimal listPrice) {
        return listPrice.multiply(new BigDecimal("0.85")).setScale(2);
    }
    public String getCondition() { return "Demo (15% off)"; }
}
