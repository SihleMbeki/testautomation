public class Main {
    public static void main(String[] args) {
        GameWeapon decorated = new GlowCharm(
                new ConfettiTrail(new SoundBadge(new ArcadeBlaster())));
        System.out.println("Loadout: " + decorated.description());
        decorated.aim();
        decorated.fire();
    }
}
