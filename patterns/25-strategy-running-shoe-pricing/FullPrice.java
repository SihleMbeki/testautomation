import java.math.BigDecimal;

public class FullPrice implements PricingStrategy {
    public BigDecimal price(BigDecimal listPrice) { return listPrice; }
    public String getCondition() { return "Full price"; }
}
