import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Naive {
    public static void main(String[] args) {
        List<String> songs = new ArrayList<String>();
        songs.add("First Light");
        songs.add("Open Road");
        songs.add("Night Drive");
        songs.add("Home Again");

        // Every caller must know list size, index rules, and how to create each order.
        for (int index = 0; index < songs.size(); index++) {
            System.out.println("NAIVE forward[" + index + "]: " + songs.get(index));
        }
        List<String> reverse = new ArrayList<String>(songs);
        Collections.reverse(reverse);
        for (int index = 0; index < reverse.size(); index++) {
            System.out.println("NAIVE reverse[" + index + "]: " + reverse.get(index));
        }
    }
}
