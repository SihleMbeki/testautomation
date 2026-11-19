public class LeavingHomeFacade {
    private final Lights lights; private final Windows windows; private final DoorLock door; private final Alarm alarm;
    public LeavingHomeFacade(Lights lights, Windows windows, DoorLock door, Alarm alarm) {
        this.lights = lights; this.windows = windows; this.door = door; this.alarm = alarm;
    }
    public void leaveHome() { lights.off(); windows.close(); door.lock(); alarm.arm(); }
}
