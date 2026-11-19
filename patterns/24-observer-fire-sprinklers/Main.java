public class Main {
    public static void main(String[] args) {
        SmokeSensor room1 = new SmokeSensor(1);
        SmokeSensor room2 = new SmokeSensor(2);
        room1.addObserver(new Sprinkler(1));
        room1.addObserver(new Sprinkler(2));
        room2.addObserver(new Sprinkler(1));
        room2.addObserver(new Sprinkler(2));
        room1.detectSmoke();
        room2.detectSmoke();
    }
}
