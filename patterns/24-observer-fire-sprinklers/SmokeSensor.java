import java.util.ArrayList;
import java.util.List;

public class SmokeSensor {
    private final int roomNumber;
    private final List<FireObserver> observers = new ArrayList<FireObserver>();
    public SmokeSensor(int roomNumber) { this.roomNumber = roomNumber; }
    public void addObserver(FireObserver observer) { observers.add(observer); }
    public void detectSmoke() {
        System.out.println("Smoke detected in room " + roomNumber + ".");
        for (FireObserver observer : observers) observer.onSmokeDetected(roomNumber);
    }
}
