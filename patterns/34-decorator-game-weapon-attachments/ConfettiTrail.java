public class ConfettiTrail extends WeaponAttachment {
    public ConfettiTrail(GameWeapon weapon) { super(weapon, "confetti trail"); }

    public void fire() {
        weapon.fire();
        System.out.println("Confetti trail: colorful confetti!");
    }
}
