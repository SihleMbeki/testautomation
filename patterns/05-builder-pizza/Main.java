public class Main {
    public static void main(String[] args) {
        System.out.println("BUILDER - Pizza orders");
        Pizza defaults = new Pizza.Builder().build();
        Pizza custom = new Pizza.Builder().size("large").base("thin").cheese(true).addTopping("mushroom").addTopping("olive").addTopping("pepper").build();
        System.out.println("Default: " + defaults.describe());
        System.out.println("Custom: " + custom.describe());
    }
}
