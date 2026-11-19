import java.util.ArrayList;
import java.util.List;

public class AlarmSensor {
    private final List<AlarmObserver> observers = new ArrayList<AlarmObserver>();
    public void addObserver(AlarmObserver observer) { observers.add(observer); }
    public void detect(String objectName) {
        System.out.println("Sensor detected " + objectName + ".");
        for (AlarmObserver observer : observers) observer.onDetection(objectName);
    }
}
