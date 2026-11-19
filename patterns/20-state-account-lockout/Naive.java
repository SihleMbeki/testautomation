public class Naive {
    public static void main(String[] args) {
        boolean locked = false;
        int failures = 0;
        String[] passwords = { "wrong", "wrong", "wrong", "secret" };
        // Duplicating lock checks and attempt-count rules across login paths gets brittle.
        for (String password : passwords) {
            if (locked) {
                System.out.println("Account locked.");
            } else if ("secret".equals(password)) {
                failures = 0;
                System.out.println("Login successful; failed-attempt counter reset.");
            } else {
                failures++;
                if (failures == 3) {
                    locked = true;
                    System.out.println("Login failed; account locked.");
                } else {
                    System.out.println("Login failed; " + (3 - failures) + " attempts remaining.");
                }
            }
        }
    }
}
