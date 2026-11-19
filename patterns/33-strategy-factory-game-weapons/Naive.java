public class Naive {
    public static void main(String[] args) {
        String choice = "rifle";
        // A player with a growing if/else cannot switch by delegating one operation.
        if ("rifle".equals(choice)) {
            System.out.println("Rifle: friendly ping!");
        } else if ("pistol".equals(choice)) {
            System.out.println("Pistol: friendly pop!");
        }
    }
}
