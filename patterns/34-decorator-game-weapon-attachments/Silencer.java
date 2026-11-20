public class Silencer extends WeaponDecorator {
    public Silencer(Weapon weapon) {
        super(weapon);
    }

    public void aim() {
        weapon.aim();
    }

    public void fire() {
        System.out.println("Silencer: quiet arcade sound.");
        weapon.fire();
    }
}
