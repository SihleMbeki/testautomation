import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class PlaylistIterator implements Iterator<Song> {
    private final List<Song> traversal;
    private int index;

    public PlaylistIterator(List<Song> traversal) {
        this.traversal = traversal;
    }

    @Override
    public boolean hasNext() {
        return index < traversal.size();
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Playlist has no more songs");
        }
        return traversal.get(index++);
    }
}
