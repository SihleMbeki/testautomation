public class Main {
    public static void main(String[] args) {
        String name = args.length == 0 ? "dog" : args[0];
        try { System.out.println("FACTORY - Animal sounds"); System.out.println(name.toLowerCase() + ": " + AnimalFactory.create(name).sound()); }
        catch (IllegalArgumentException ex) { System.out.println(ex.getMessage()); }
    }
}
