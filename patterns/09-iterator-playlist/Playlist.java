import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class Playlist implements Iterable<Song> {
    private final List<Song> songs = new ArrayList<Song>();

    public void add(Song song) {
        songs.add(song);
    }

    @Override
    public Iterator<Song> iterator() {
        return new PlaylistIterator(songs);
    }

    public Iterator<Song> reverseIterator() {
        List<Song> reversed = new ArrayList<Song>(songs);
        Collections.reverse(reversed);
        return new PlaylistIterator(reversed);
    }

    public Iterator<Song> shuffledIterator(long seed) {
        List<Song> shuffled = new ArrayList<Song>(songs);
        Collections.shuffle(shuffled, new Random(seed));
        return new PlaylistIterator(shuffled);
    }
}
