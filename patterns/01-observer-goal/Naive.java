import java.util.ArrayList;
import java.util.List;

public class Naive {
    public static void main(String[] args) {
        List<String> listeners = new ArrayList<>();
        listeners.add("scoreboard");
        listeners.add("commentator");
        listeners.add("fans");
        // Pain: Match must know every audience and add another special case for each new listener.
        System.out.println("NAIVE - Match with hard-wired reactions");
        System.out.println("GOAL! Home 1 - Away 0");
        for (String listener : listeners) {
            if (listener.equals("scoreboard")) System.out.println("Scoreboard: Home 1 - Away 0");
            else if (listener.equals("commentator")) System.out.println("Commentator: GOAL!");
            else if (listener.equals("fans")) System.out.println("Fans: We are cheering!");
        }
        System.out.println("Adding a radio station means editing Match's reaction list.");
    }
}
