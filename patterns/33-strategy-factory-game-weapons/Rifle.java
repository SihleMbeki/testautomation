public class Rifle implements Weapon {
    public void aim() { System.out.println("Rifle: aiming at the arcade target"); }
    public void fire() { System.out.println("Rifle: friendly ping!"); }
    public String name() { return "rifle"; }
}
