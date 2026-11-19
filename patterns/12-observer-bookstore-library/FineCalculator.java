import java.time.LocalDate;

public interface FineCalculator {
    double calculate(LocalDate dueDate, LocalDate currentDate);
}
