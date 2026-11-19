public class CupMatch extends Match {
    protected String name() { return "Cup"; }
    protected int firstHalfHome() { return 1; } protected int firstHalfAway() { return 0; }
    protected int secondHalfHome() { return 0; } protected int secondHalfAway() { return 1; }
    protected void tiedAtFullTime(int home, int away) { System.out.println("Cup: Penalties - Home wins 4-3"); }
}
