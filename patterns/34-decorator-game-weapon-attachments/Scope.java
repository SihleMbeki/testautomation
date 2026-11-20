public class Scope extends WeaponDecorator {
    public Scope(Weapon weapon) {
        super(weapon);
    }

    public void aim() {
        System.out.println("Scope: aiming with 4x zoom.");
        weapon.aim();
    }

    public void fire() {
        weapon.fire();
    }
}
