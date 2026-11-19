import java.util.Arrays;
import java.util.List;

public class LeaderboardViewer implements LeaderboardObserver {
    private final String name;
    private final List<RankingStrategy> strategies;
    public LeaderboardViewer(String name) {
        this.name = name;
        this.strategies = Arrays.<RankingStrategy>asList(
                new CategoryRankingStrategy("Male"),
                new CategoryRankingStrategy("Female"),
                new CategoryRankingStrategy("Combined"));
    }
    public void update(List<RunnerUpdate> runners) {
        System.out.println("Update for " + name + ":");
        for (RankingStrategy strategy : strategies) {
            List<RunnerUpdate> ranked = strategy.rank(runners);
            System.out.print(strategy.getCategory() + " top 10: ");
            for (int i = 0; i < ranked.size(); i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(ranked.get(i).getName() + " (" + ranked.get(i).getSeconds() + "s)");
            }
            System.out.println();
        }
    }
}
