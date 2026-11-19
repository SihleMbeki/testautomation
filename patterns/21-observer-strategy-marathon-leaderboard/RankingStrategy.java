import java.util.List;

public interface RankingStrategy {
    String getCategory();
    List<RunnerUpdate> rank(List<RunnerUpdate> runners);
}
