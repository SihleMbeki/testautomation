import java.time.LocalTime;

public class OffState implements AlarmState {
    public String name() { return "Off"; }
    public void setAlarm(AlarmClock clock, LocalTime time) {
        clock.setAlarmTime(time);
        clock.setState(new SetState());
        System.out.println("Alarm set for " + time);
    }
    public void advanceTo(AlarmClock clock, LocalTime time) {
        clock.reject("advance time");
    }
    public void snooze(AlarmClock clock) { clock.reject("snooze"); }
    public void cancel(AlarmClock clock) { clock.reject("cancel"); }
}
