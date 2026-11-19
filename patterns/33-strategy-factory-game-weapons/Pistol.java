public class Pistol implements Weapon {
    public void aim() { System.out.println("Pistol: aiming at the arcade target"); }
    public void fire() { System.out.println("Pistol: friendly pop!"); }
    public String name() { return "pistol"; }
}
