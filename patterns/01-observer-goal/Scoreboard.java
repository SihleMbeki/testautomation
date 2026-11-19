public class Scoreboard implements MatchListener {
    public void onGoal(String team, int home, int away) { System.out.println("Scoreboard: Home " + home + " - Away " + away); }
}
