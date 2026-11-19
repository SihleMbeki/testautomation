public class LeagueMatch extends Match {
    protected String name() { return "League"; }
    protected int firstHalfHome() { return 1; } protected int firstHalfAway() { return 0; }
    protected int secondHalfHome() { return 0; } protected int secondHalfAway() { return 0; }
}
