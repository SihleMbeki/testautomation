public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        try {
            String first = args.length > 0 ? args[0] : "rifle";
            String second = args.length > 1 ? args[1] : "pistol";
            player.switchWeapon(WeaponFactory.create(first));
            player.aimAndFire();
            player.switchWeapon(WeaponFactory.create(second));
            player.aimAndFire();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
