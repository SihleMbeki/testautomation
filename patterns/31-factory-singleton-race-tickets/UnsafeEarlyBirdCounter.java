import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class UnsafeEarlyBirdCounter implements EarlyBirdCounter {
    private int sold;
    private CyclicBarrier raceBarrier;

    public UnsafeEarlyBirdCounter(int alreadySold, int racers) {
        sold = alreadySold;
        raceBarrier = new CyclicBarrier(racers);
    }

    public boolean claimShirt() {
        int observed = sold;
        try {
            // Hold all contenders after the same boundary read to make the race repeatable.
            raceBarrier.await();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Race demo interrupted", exception);
        } catch (BrokenBarrierException exception) {
            throw new IllegalStateException("Race demo barrier failed", exception);
        }
        if (observed < 1000) {
            sold = observed + 1;
            return true;
        }
        return false;
    }
}
