import java.util.Iterator;

public class Main {
    private static String titles(Iterator<Song> songs) {
        StringBuilder result = new StringBuilder();
        while (songs.hasNext()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(songs.next().getTitle());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.add(new Song("First Light"));
        playlist.add(new Song("Open Road"));
        playlist.add(new Song("Night Drive"));
        playlist.add(new Song("Home Again"));
        System.out.println("FORWARD: " + titles(playlist.iterator()));
        System.out.println("REVERSE: " + titles(playlist.reverseIterator()));
        System.out.println("SHUFFLE (seed 7): " + titles(playlist.shuffledIterator(7)));
        System.out.println("SHUFFLE (seed 7): " + titles(playlist.shuffledIterator(7)));
    }
}
