public class ArcadeBlaster implements GameWeapon {
    public void aim() { System.out.println("Arcade blaster: aiming at the target"); }
    public void fire() { System.out.println("Arcade blaster: friendly ping!"); }
    public String description() { return "Arcade blaster"; }
}
