public class Main {
    public static void main(String[] args) {
        System.out.println("OBSERVER - Match updates");
        Match match = new Match();
        match.addListener(new Scoreboard());
        match.addListener(new Commentator());
        match.addListener(new Fans());
        match.addListener(new RadioStation());
        match.scoreGoal("Home");
    }
}
