public class Naive {
    public static void main(String[] args) {
        // Room-to-sprinkler wiring and all activation decisions live in sensor logic.
        int roomWithSmoke = 1;
        System.out.println("Smoke detected in room " + roomWithSmoke + ".");
        if (roomWithSmoke == 1) System.out.println("Sprinkler activated in room 1.");
        if (roomWithSmoke == 2) System.out.println("Sprinkler activated in room 2.");
        roomWithSmoke = 2;
        System.out.println("Smoke detected in room " + roomWithSmoke + ".");
        if (roomWithSmoke == 1) System.out.println("Sprinkler activated in room 1.");
        if (roomWithSmoke == 2) System.out.println("Sprinkler activated in room 2.");
    }
}
