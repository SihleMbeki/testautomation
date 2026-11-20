import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceDemo {
    public static int unsafeTotalShirtCount(int racers) throws InterruptedException {
        final TicketFactory factory = new TicketFactory(
                new UnsafeEarlyBirdCounter(999, racers));
        final CountDownLatch ready = new CountDownLatch(racers);
        final CountDownLatch start = new CountDownLatch(1);
        final AtomicInteger shirts = new AtomicInteger();
        Thread[] threads = new Thread[racers];
        for (int i = 0; i < racers; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    ready.countDown();
                    try {
                        start.await();
                        if (factory.buy().hasFreeShirt()) shirts.incrementAndGet();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }
        ready.await();
        start.countDown();
        for (Thread thread : threads) thread.join();
        return 999 + shirts.get();
    }

    public static int safeShirtCount(int buyers) throws InterruptedException {
        final TicketFactory factory = new TicketFactory(new SafeEarlyBirdCounter());
        final CountDownLatch ready = new CountDownLatch(buyers);
        final CountDownLatch start = new CountDownLatch(1);
        final AtomicInteger shirts = new AtomicInteger();
        Thread[] threads = new Thread[buyers];
        for (int i = 0; i < buyers; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    ready.countDown();
                    try {
                        start.await();
                        if (factory.buy().hasFreeShirt()) shirts.incrementAndGet();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }
        ready.await();
        start.countDown();
        for (Thread thread : threads) thread.join();
        return shirts.get();
    }
}
