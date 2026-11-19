import java.math.BigDecimal;

public class TicketFareCalculator {
    private static final BigDecimal BASE_FARE = new BigDecimal("400.00");

    public BigDecimal quote(String origin, String destination) {
        String normalizedOrigin = ProvinceNames.normalize(origin);
        String normalizedDestination = ProvinceNames.normalize(destination);
        if (normalizedOrigin == null) {
            throw new IllegalArgumentException("Unknown province: " + origin);
        }
        if (normalizedDestination == null) {
            throw new IllegalArgumentException("Unknown province: " + destination);
        }

        FareStrategy strategy = normalizedOrigin.equals(normalizedDestination)
                ? new IntraProvinceFare() : new InterProvinceFare();
        return strategy.quote(BASE_FARE);
    }
}
