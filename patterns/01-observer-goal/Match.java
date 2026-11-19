import java.util.ArrayList;
import java.util.List;

public class Match {
    private final List<MatchListener> listeners = new ArrayList<>();
    private int homeScore;
    private int awayScore;

    public void addListener(MatchListener listener) { listeners.add(listener); }
    public void scoreGoal(String team) {
        if (team.equalsIgnoreCase("home")) homeScore++; else awayScore++;
        for (MatchListener listener : listeners) listener.onGoal(team, homeScore, awayScore);
    }
}
