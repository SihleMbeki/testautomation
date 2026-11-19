import java.util.List;

public interface LeaderboardObserver {
    void update(List<RunnerUpdate> runners);
}
