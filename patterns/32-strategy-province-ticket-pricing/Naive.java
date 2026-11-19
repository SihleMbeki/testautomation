public class Naive {
    public static void main(String[] args) {
        String origin = "KZN";
        String destination = "Gauteng";
        // Aliases and fare rules become a fragile chain in the caller.
        if (origin.equals(destination)) {
            System.out.println("Naive fare: R400.00");
        } else {
            System.out.println("Naive fare: R440.00");
        }
    }
}
