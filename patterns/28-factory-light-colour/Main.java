public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            LightFactory.create(args[0]).turnOn();
            return;
        }
        LightFactory.create("red").turnOn();
        LightFactory.create("green").turnOn();
        LightFactory.create("orange").turnOn();
    }
}
