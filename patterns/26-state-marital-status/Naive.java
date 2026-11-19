public class Naive {
    public static void main(String[] args) {
        String status = "Single";
        // Every new rule adds another condition and can forget a status.
        if ("Single".equals(status)) {
            System.out.println("Cannot divorce: person is Single");
        }
    }
}
