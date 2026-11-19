public class SoundBadge extends WeaponAttachment {
    public SoundBadge(GameWeapon weapon) { super(weapon, "sound badge"); }

    public void fire() {
        weapon.fire();
        System.out.println("Sound badge: cheerful arcade chime!");
    }
}
