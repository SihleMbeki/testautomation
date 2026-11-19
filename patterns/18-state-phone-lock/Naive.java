public class Naive {
    public static void main(String[] args) {
        boolean locked = true;
        // As more phone actions and states appear, callers accumulate conditionals.
        if (locked) System.out.println("Phone is locked; key ignored.");
        locked = false;
        if (!locked) System.out.println("Phone unlocked.");
        if (!locked) System.out.println("Dialling 555-0100.");
        locked = true;
        if (locked) System.out.println("Phone locked.");
    }
}
