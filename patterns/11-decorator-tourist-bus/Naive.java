public class Naive {
    public static void main(String[] args) {
        boolean meal = true;
        boolean insurance = true;
        boolean luggage = false;
        // Every new combination needs another condition or another hard-coded total.
        double total = 150;
        String description = "Basic entry";
        if (meal) {
            total += 25;
            description += " + meal";
        }
        if (insurance) {
            total += 15;
            description += " + insurance";
        }
        if (luggage) {
            total += 20;
            description += " + luggage";
        }
        System.out.printf("NAIVE %s = R%.2f%n", description, total);
    }
}
