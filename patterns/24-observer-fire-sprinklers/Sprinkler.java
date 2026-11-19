public class Sprinkler implements FireObserver {
    private final int roomNumber;
    public Sprinkler(int roomNumber) { this.roomNumber = roomNumber; }
    public void onSmokeDetected(int detectedRoom) {
        if (roomNumber == detectedRoom) System.out.println("Sprinkler activated in room " + roomNumber + ".");
    }
}
