import java.time.LocalDate;

public class Naive {
    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2026, 6, 1);
        LocalDate dueDate = LocalDate.of(2026, 6, 3);
        System.out.println("NAIVE date: " + today);
        // The lending code must know every view and call each one after every date change.
        showReminder(dueDate, today);
        showExpired(dueDate, today);
        today = today.plusDays(4);
        System.out.println("NAIVE date: " + today);
        showReminder(dueDate, today);
        showExpired(dueDate, today);
    }

    private static void showReminder(LocalDate due, LocalDate today) {
        if (!due.isAfter(today.plusDays(3))) {
            System.out.println("NAIVE REMINDER: The Long Way Home");
        }
    }

    private static void showExpired(LocalDate due, LocalDate today) {
        if (due.isBefore(today)) {
            System.out.println("NAIVE EXPIRED: The Long Way Home");
        }
    }
}
