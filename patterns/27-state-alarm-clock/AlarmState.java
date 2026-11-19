import java.time.LocalTime;

public interface AlarmState {
    String name();
    void setAlarm(AlarmClock clock, LocalTime time);
    void advanceTo(AlarmClock clock, LocalTime time);
    void snooze(AlarmClock clock);
    void cancel(AlarmClock clock);
}
