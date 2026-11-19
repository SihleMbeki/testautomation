public class Main {
    public static void main(String[] args) {
        AlarmSensor sensor = new AlarmSensor();
        sensor.addObserver(new AlarmOwner());
        sensor.detect("movement");
    }
}
