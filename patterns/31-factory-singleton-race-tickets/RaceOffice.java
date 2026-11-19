import java.util.concurrent.atomic.AtomicInteger;

public enum RaceOffice {
    INSTANCE;

    private final AtomicInteger nextNumber = new AtomicInteger(1);

    public int nextRaceNumber() { return nextNumber.getAndIncrement(); }
}
