import java.math.BigDecimal;
import java.math.RoundingMode;

public class IntraProvinceFare implements FareStrategy {
    public BigDecimal quote(BigDecimal baseFare) {
        return baseFare.setScale(2, RoundingMode.HALF_UP);
    }
}
