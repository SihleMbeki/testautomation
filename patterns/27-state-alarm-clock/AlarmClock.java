import java.time.LocalTime;

public class AlarmClock {
    private AlarmState state = new OffState();
    private LocalTime currentTime;
    private LocalTime alarmTime;

    public AlarmClock(LocalTime startingTime) {
        currentTime = startingTime;
    }

    public String stateName() { return state.name(); }
    public LocalTime currentTime() { return currentTime; }
    LocalTime alarmTime() { return alarmTime; }

    void setState(AlarmState next) { state = next; }
    void setAlarmTime(LocalTime time) { alarmTime = time; }
    void setCurrentTime(LocalTime time) { currentTime = time; }

    public void setAlarm(LocalTime time) { state.setAlarm(this, time); }
    public void advanceTo(LocalTime time) { state.advanceTo(this, time); }
    public void snooze() { state.snooze(this); }
    public void cancel() { state.cancel(this); }

    void reject(String action) {
        System.out.println("Cannot " + action + " while alarm is " + state.name());
    }
}
