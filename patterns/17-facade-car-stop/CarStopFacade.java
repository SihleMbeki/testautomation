public class CarStopFacade {
    private final Brake brake = new Brake();
    private final Gearbox gearbox = new Gearbox();
    private final Handbrake handbrake = new Handbrake();
    private final Lights lights = new Lights();
    private final Engine engine = new Engine();

    public void stopManualCar() {
        brake.apply();
        gearbox.selectFirst();
        brake.applyFurther();
        gearbox.selectNeutral();
        handbrake.engage();
        lights.turnOff();
        engine.stop();
    }
}
