public class Naive {
    public static void main(String[] args) {
        int sold = 999;
        // Separate check and increment can let every concurrent buyer pass.
        if (sold < 1000) {
            System.out.println("Naive check: a shirt is available");
            sold++;
        }
        System.out.println("Naive local sold count: " + sold);
    }
}
