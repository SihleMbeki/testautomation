public class LightFactory {
    public static Light create(String colour) {
        if ("red".equalsIgnoreCase(colour)) return new RedLight();
        if ("green".equalsIgnoreCase(colour)) return new GreenLight();
        if ("orange".equalsIgnoreCase(colour)) return new OrangeLight();
        throw new IllegalArgumentException("Unknown light colour: " + colour);
    }
}
