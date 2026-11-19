import java.math.BigDecimal;

public interface FareStrategy {
    BigDecimal quote(BigDecimal baseFare);
}
