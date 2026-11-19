public class Naive {
    public static void main(String[] args) {
        String method = "card";
        double amount = 250.0;
        // Pain: every new payment method adds another branch and duplicates receipt logic.
        System.out.println("NAIVE - Growing payment if/else");
        if (method.equals("card")) System.out.printf("Card payment R%.2f fee R%.2f%n", amount, 5.0);
        else if (method.equals("cash")) System.out.printf("Cash payment R%.2f fee R%.2f%n", amount, 0.0);
        else if (method.equals("eft")) System.out.printf("EFT payment R%.2f fee R%.2f%n", amount, 2.5);
        else System.out.println("Unsupported payment method");
        System.out.println("A wallet requires yet another branch here.");
    }
}
