import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal price(BigDecimal listPrice);
    String getCondition();
}
