public class GlowCharm extends WeaponAttachment {
    public GlowCharm(GameWeapon weapon) { super(weapon, "glow charm"); }

    public void aim() {
        System.out.println("Glow charm: target sparkles");
        weapon.aim();
    }
}
