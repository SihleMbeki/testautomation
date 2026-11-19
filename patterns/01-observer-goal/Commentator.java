public class Commentator implements MatchListener {
    public void onGoal(String team, int home, int away) { System.out.println("Commentator: GOAL! " + team + " scored."); }
}
