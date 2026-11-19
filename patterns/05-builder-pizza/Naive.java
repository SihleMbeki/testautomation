public class Naive {
    static class Pizza {
        String size, base; boolean cheese; String topping1, topping2, topping3;
        Pizza(String size, String base, boolean cheese, String topping1, String topping2, String topping3) {
            this.size=size; this.base=base; this.cheese=cheese; this.topping1=topping1; this.topping2=topping2; this.topping3=topping3;
        }
    }
    public static void main(String[] args) {
        // Pain: positional arguments are hard to read, and a fixed topping limit forces constructor changes.
        Pizza order = new Pizza("large", "thin", true, "mushroom", "olive", "pepper");
        System.out.println("NAIVE - Long positional constructor");
        System.out.println(order.size + " " + order.base + " cheese=" + order.cheese + " toppings=" + order.topping1 + ", " + order.topping2 + ", " + order.topping3);
    }
}
