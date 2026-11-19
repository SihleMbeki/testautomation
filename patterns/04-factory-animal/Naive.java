public class Naive {
    public static void main(String[] args) {
        String type = args.length == 0 ? "dog" : args[0].toLowerCase();
        // Pain: each caller repeats this branching and constructor knowledge.
        System.out.println("NAIVE - Caller chooses concrete class");
        if (type.equals("dog")) System.out.println("dog: Woof!");
        else if (type.equals("cat")) System.out.println("cat: Meow!");
        else if (type.equals("cow")) System.out.println("cow: Moo!");
        else System.out.println("Unknown animal: " + type);
    }
}
