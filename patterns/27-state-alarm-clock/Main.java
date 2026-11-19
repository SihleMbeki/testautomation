import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock(LocalTime.of(7, 0));
        clock.setAlarm(LocalTime.of(7, 5));
        clock.setAlarm(LocalTime.of(7, 10));
        clock.advanceTo(LocalTime.of(7, 5));
        clock.snooze();
        clock.advanceTo(LocalTime.of(7, 35));
        clock.cancel();
        clock.cancel();
        System.out.println("Final state: " + clock.stateName());
    }
}
