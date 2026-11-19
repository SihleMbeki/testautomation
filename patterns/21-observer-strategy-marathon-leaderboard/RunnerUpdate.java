public class RunnerUpdate {
    private final String name;
    private final String category;
    private final int seconds;

    public RunnerUpdate(String name, String category, int seconds) {
        this.name = name;
        this.category = category;
        this.seconds = seconds;
    }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getSeconds() { return seconds; }
}
