public class Naive {
    public static void main(String[] args) {
        // Pain: enumerating combinations makes code branchy; double milk needs another special case.
        boolean milk=true, sugar=true, cream=true, doubleMilk=true;
        double total=20 + (milk ? 5 : 0) + (doubleMilk ? 5 : 0) + (sugar ? 2 : 0) + (cream ? 8 : 0);
        System.out.println("NAIVE - Flags and combination arithmetic");
        System.out.printf("Coffee with milk, double milk, sugar, cream R%.2f%n", total);
    }
}
