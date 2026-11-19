public class Naive {
    public static void main(String[] args) {
        // Pain: every caller must know all subsystem objects and remember the safe order.
        System.out.println("NAIVE - Client coordinates every subsystem");
        System.out.println("Lights: off");
        System.out.println("Windows: closed");
        System.out.println("Door: locked");
        System.out.println("Alarm: armed");
    }
}
