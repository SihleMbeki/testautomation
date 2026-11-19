import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class DailyFineCalculator implements FineCalculator {
    private final double dailyRate;

    public DailyFineCalculator(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculate(LocalDate dueDate, LocalDate currentDate) {
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
        return Math.max(0, daysOverdue) * dailyRate;
    }
}
