import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceDemo {
    private static final int GATES = 3;
    private static final int PER_GATE = 100;
    public static int run(boolean threadSafe) throws InterruptedException {
        if (threadSafe) TicketCounter.getInstance().reset(); else UnsafeTicketCounter.getInstance().reset();
        Set<Integer> tickets = ConcurrentHashMap.newKeySet();
        AtomicInteger duplicates = new AtomicInteger();
        CountDownLatch start = new CountDownLatch(1), done = new CountDownLatch(GATES);
        for (int gate = 0; gate < GATES; gate++) {
            Thread worker = new Thread(() -> {
                try {
                    start.await();
                    for (int i = 0; i < PER_GATE; i++) {
                        int ticket = threadSafe ? TicketCounter.getInstance().nextTicket() : UnsafeTicketCounter.getInstance().nextTicket();
                        if (!tickets.add(ticket)) duplicates.incrementAndGet();
                    }
                } catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
                finally { done.countDown(); }
            });
            worker.start();
        }
        start.countDown(); done.await();
        return duplicates.get();
    }
}
