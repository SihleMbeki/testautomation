import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CategoryRankingStrategy implements RankingStrategy {
    private final String category;
    public CategoryRankingStrategy(String category) { this.category = category; }
    public String getCategory() { return category; }

    public List<RunnerUpdate> rank(List<RunnerUpdate> runners) {
        List<RunnerUpdate> result = new ArrayList<RunnerUpdate>();
        for (RunnerUpdate runner : runners) {
            if ("Combined".equals(category) || category.equals(runner.getCategory())) result.add(runner);
        }
        Collections.sort(result, new Comparator<RunnerUpdate>() {
            public int compare(RunnerUpdate a, RunnerUpdate b) {
                int time = Integer.compare(a.getSeconds(), b.getSeconds());
                return time != 0 ? time : a.getName().compareTo(b.getName());
            }
        });
        if (result.size() > 10) return new ArrayList<RunnerUpdate>(result.subList(0, 10));
        return result;
    }
}
