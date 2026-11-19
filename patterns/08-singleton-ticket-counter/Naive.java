import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class Naive {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("NAIVE - Unsafe singleton under concurrent gates");
        // Unsynchronized increments let concurrent gates issue duplicate tickets.
        int duplicates = RaceDemo.run(false);
        System.out.println("Unsafe duplicate ticket numbers: " + duplicates);
    }
}
