public class Main {
    public static void main(String[] args) {
        System.out.println("DECORATOR - Coffee add-ons (Rand)");
        Coffee plain = new PlainCoffee();
        Coffee deluxe = new Cream(new Sugar(new Milk(new Milk(new PlainCoffee()))));
        System.out.printf("%s: R%.2f%n", plain.description(), plain.cost());
        System.out.printf("%s: R%.2f%n", deluxe.description(), deluxe.cost());
    }
}
