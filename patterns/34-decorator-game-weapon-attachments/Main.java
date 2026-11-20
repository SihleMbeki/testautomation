public class Main {
    public static void main(String[] args) {
        Weapon rifle = new Rifle();

        System.out.println("Base rifle:");
        rifle.aim();
        rifle.fire();

        System.out.println("\nScope attached:");
        Weapon scopedRifle = new Scope(rifle);
        scopedRifle.aim();
        scopedRifle.fire();

        System.out.println("\nScope removed:");
        rifle.aim();
        rifle.fire();

        System.out.println("\nSilencer and scope attached:");
        Weapon combined = new Silencer(new Scope(new Rifle()));
        combined.aim();
        combined.fire();
    }
}
