import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterProvinceFare implements FareStrategy {
    private static final BigDecimal RATE = new BigDecimal("1.10");

    public BigDecimal quote(BigDecimal baseFare) {
        return baseFare.multiply(RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
