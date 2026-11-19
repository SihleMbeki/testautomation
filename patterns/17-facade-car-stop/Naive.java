public class Naive {
    public static void main(String[] args) {
        Brake brake = new Brake();
        Gearbox gearbox = new Gearbox();
        Handbrake handbrake = new Handbrake();
        Lights lights = new Lights();
        Engine engine = new Engine();
        // Every caller must remember all seven actions and their safety-critical order.
        brake.apply();
        gearbox.selectFirst();
        brake.applyFurther();
        gearbox.selectNeutral();
        handbrake.engage();
        lights.turnOff();
        engine.stop();
    }
}
