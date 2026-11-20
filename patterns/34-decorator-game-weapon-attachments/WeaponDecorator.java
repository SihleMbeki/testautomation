public abstract class WeaponDecorator implements Weapon {
    protected final Weapon weapon;

    protected WeaponDecorator(Weapon weapon) {
        this.weapon = weapon;
    }
}
