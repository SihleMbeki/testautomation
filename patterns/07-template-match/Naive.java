public class Naive {
    public static void main(String[] args) {
        // Pain: duplicating the whole match schedule for each type invites ordering drift.
        System.out.println("NAIVE - Duplicated match sequence");
        System.out.println("League: Kick off"); System.out.println("League: First half"); System.out.println("League: Half time");
        System.out.println("League: Second half"); System.out.println("League: Full time (1-0)");
        System.out.println("Cup: Kick off"); System.out.println("Cup: First half"); System.out.println("Cup: Half time");
        System.out.println("Cup: Second half"); System.out.println("Cup: Full time (1-1)"); System.out.println("Cup: Penalties - Home wins 4-3");
    }
}
