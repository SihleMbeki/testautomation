public class LightFactory {
    public static Light create(String colour) {
        if ("red".equalsIgnoreCase(colour)) return new RedLight();
        if ("green".equalsIgnoreCase(colour)) return new GreenLight();
        throw new IllegalArgumentException("Unknown light colour: " + colour);
    }
}
