import java.math.BigDecimal;

public class SecondHandPrice implements PricingStrategy {
    public BigDecimal price(BigDecimal listPrice) {
        return listPrice.multiply(new BigDecimal("0.60")).setScale(2);
    }
    public String getCondition() { return "Second hand (40% off)"; }
}
