public class Player {
    private Weapon weapon;

    public void switchWeapon(Weapon next) {
        weapon = next;
        System.out.println("Player switched to " + weapon.name());
    }

    public void aimAndFire() {
        weapon.aim();
        weapon.fire();
    }
}
