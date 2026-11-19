public class Naive {
    public static void main(String[] args) {
        String state = "Off";
        // These checks spread state-specific rules across the clock.
        if ("Off".equals(state)) {
            System.out.println("Cannot snooze while alarm is Off");
        }
    }
}
