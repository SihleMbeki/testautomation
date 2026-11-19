public class Room {
    private final Light light;

    public Room(Light light) { this.light = light; }
    public void brighten() { light.turnOn(); }
    public void darken() { light.turnOff(); }
}
