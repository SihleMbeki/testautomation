public class Main {
    public static void main(String[] args) {
        MarathonLeaderboard board = new MarathonLeaderboard();
        board.addViewer(new LeaderboardViewer("Race app"));
        board.addViewer(new LeaderboardViewer("Finish-line display"));
        board.addRunnerUpdate(new RunnerUpdate("Ava", "Female", 7200));
        board.addRunnerUpdate(new RunnerUpdate("Ben", "Male", 6900));
        board.addRunnerUpdate(new RunnerUpdate("Cara", "Female", 7100));
    }
}
