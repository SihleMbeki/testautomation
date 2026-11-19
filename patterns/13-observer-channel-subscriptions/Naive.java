public class Naive {
    public static void main(String[] args) {
        boolean avaSubscribed = true;
        boolean benSubscribed = true;
        System.out.println("NAIVE publish: New routes announced");
        // The publisher must keep recipient-specific knowledge and remember membership flags.
        if (avaSubscribed) {
            notifyAva("New routes announced");
        }
        if (benSubscribed) {
            notifyBen("New routes announced");
        }
        avaSubscribed = false;
        System.out.println("NAIVE publish: Weekend fares available");
        if (avaSubscribed) {
            notifyAva("Weekend fares available");
        }
        if (benSubscribed) {
            notifyBen("Weekend fares available");
        }
    }

    private static void notifyAva(String message) {
        System.out.println("NAIVE notify Ava: " + message);
    }

    private static void notifyBen(String message) {
        System.out.println("NAIVE notify Ben: " + message);
    }
}
