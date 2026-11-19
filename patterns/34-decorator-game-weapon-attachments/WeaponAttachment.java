public abstract class WeaponAttachment implements GameWeapon {
    protected final GameWeapon weapon;
    private final String attachmentName;

    protected WeaponAttachment(GameWeapon weapon, String attachmentName) {
        this.weapon = weapon;
        this.attachmentName = attachmentName;
    }

    public void aim() { weapon.aim(); }
    public void fire() { weapon.fire(); }
    public String description() {
        return weapon.description() + " + " + attachmentName;
    }
}
