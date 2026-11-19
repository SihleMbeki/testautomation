public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("SINGLETON - Parking ticket counter (3 gates x 100 tickets)");
        int unsafeDuplicates = RaceDemo.run(false);
        int safeDuplicates = RaceDemo.run(true);
        System.out.println("Unsafe duplicate ticket numbers: " + unsafeDuplicates);
        System.out.println("Synchronized duplicate ticket numbers: " + safeDuplicates);
        System.out.println("WebDriver note: use ThreadLocal<WebDriver> for one driver per test thread, not a shared Singleton.");
    }
}
