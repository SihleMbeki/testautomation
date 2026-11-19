import java.util.concurrent.atomic.AtomicInteger;

public class SafeEarlyBirdCounter implements EarlyBirdCounter {
    private final AtomicInteger sold = new AtomicInteger();

    public boolean claimShirt() {
        while (true) {
            int current = sold.get();
            if (current >= 1000) return false;
            if (sold.compareAndSet(current, current + 1)) return true;
        }
    }
}
