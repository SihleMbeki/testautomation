import java.time.LocalTime;

public class SnoozedState implements AlarmState {
    public String name() { return "Snoozed"; }
    public void setAlarm(AlarmClock clock, LocalTime time) {
        clock.reject("set another alarm");
    }
    public void advanceTo(AlarmClock clock, LocalTime time) {
        if (time.isBefore(clock.currentTime())) {
            clock.reject("move the fake clock backwards");
            return;
        }
        clock.setCurrentTime(time);
        if (!time.isBefore(clock.alarmTime())) {
            clock.setState(new RingingState());
            System.out.println("Alarm ringing again at " + time);
        } else {
            System.out.println("Time is " + time + "; alarm is Snoozed");
        }
    }
    public void snooze(AlarmClock clock) { clock.reject("snooze"); }
    public void cancel(AlarmClock clock) {
        clock.setState(new OffState());
        clock.setAlarmTime(null);
        System.out.println("Alarm cancelled");
    }
}
