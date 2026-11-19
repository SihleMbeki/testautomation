import java.time.LocalTime;

public class RingingState implements AlarmState {
    public String name() { return "Ringing"; }
    public void setAlarm(AlarmClock clock, LocalTime time) {
        clock.reject("set another alarm");
    }
    public void advanceTo(AlarmClock clock, LocalTime time) {
        clock.reject("advance time");
    }
    public void snooze(AlarmClock clock) {
        LocalTime nextAlarm = clock.currentTime().plusMinutes(30);
        clock.setAlarmTime(nextAlarm);
        clock.setState(new SnoozedState());
        System.out.println("Snoozed until " + nextAlarm);
    }
    public void cancel(AlarmClock clock) {
        clock.setState(new OffState());
        clock.setAlarmTime(null);
        System.out.println("Alarm cancelled");
    }
}
