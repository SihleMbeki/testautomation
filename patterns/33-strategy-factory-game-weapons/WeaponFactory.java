public class WeaponFactory {
    public static Weapon create(String choice) {
        if ("rifle".equalsIgnoreCase(choice)) return new Rifle();
        if ("pistol".equalsIgnoreCase(choice)) return new Pistol();
        throw new IllegalArgumentException("Unknown game weapon: " + choice);
    }
}
