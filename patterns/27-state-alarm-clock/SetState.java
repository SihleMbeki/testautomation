import java.time.LocalTime;

public class SetState implements AlarmState {
    public String name() { return "Set"; }
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
            System.out.println("Alarm ringing at " + time);
        } else {
            System.out.println("Time is " + time + "; alarm is Set");
        }
    }
    public void snooze(AlarmClock clock) { clock.reject("snooze"); }
    public void cancel(AlarmClock clock) {
        clock.setState(new OffState());
        clock.setAlarmTime(null);
        System.out.println("Alarm cancelled");
    }
}
