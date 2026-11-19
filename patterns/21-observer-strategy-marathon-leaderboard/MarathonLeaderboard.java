import java.util.ArrayList;
import java.util.List;

public class MarathonLeaderboard {
    private final List<RunnerUpdate> runners = new ArrayList<RunnerUpdate>();
    private final List<LeaderboardObserver> viewers = new ArrayList<LeaderboardObserver>();

    public void addViewer(LeaderboardObserver viewer) { viewers.add(viewer); }
    public void addRunnerUpdate(RunnerUpdate runner) {
        runners.add(runner);
        notifyViewers();
    }
    private void notifyViewers() {
        List<RunnerUpdate> snapshot = new ArrayList<RunnerUpdate>(runners);
        for (LeaderboardObserver viewer : viewers) viewer.update(snapshot);
    }
}
