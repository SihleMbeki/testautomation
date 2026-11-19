public class RadioStation implements MatchListener {
    public void onGoal(String team, int home, int away) { System.out.println("Radio: Breaking goal update - " + team + " scored."); }
}
