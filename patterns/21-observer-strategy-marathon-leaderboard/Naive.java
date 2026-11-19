import java.util.ArrayList;
import java.util.List;

public class Naive {
    public static void main(String[] args) {
        List<RunnerUpdate> runners = new ArrayList<RunnerUpdate>();
        runners.add(new RunnerUpdate("Ava", "Female", 7200));
        runners.add(new RunnerUpdate("Ben", "Male", 6900));
        runners.add(new RunnerUpdate("Cara", "Female", 7100));
        // The feed now knows every display and every category, coupling updates to consumers.
        for (String viewer : new String[] { "Race app", "Finish-line display" }) {
            System.out.println("Update for " + viewer + ":");
            printCategory(runners, "Male");
            printCategory(runners, "Female");
            printCategory(runners, "Combined");
        }
    }
    private static void printCategory(List<RunnerUpdate> runners, String category) {
        java.util.List<RunnerUpdate> result = new java.util.ArrayList<RunnerUpdate>();
        for (RunnerUpdate r : runners)
            if ("Combined".equals(category) || category.equals(r.getCategory())) result.add(r);
        java.util.Collections.sort(result, new java.util.Comparator<RunnerUpdate>() {
            public int compare(RunnerUpdate a, RunnerUpdate b) { return Integer.compare(a.getSeconds(), b.getSeconds()); }
        });
        System.out.print(category + " top 10: ");
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(result.get(i).getName() + " (" + result.get(i).getSeconds() + "s)");
        }
        System.out.println();
    }
}
