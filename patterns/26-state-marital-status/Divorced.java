public class Divorced implements MaritalStatus {
    public String name() { return "Divorced"; }

    public MaritalStatus marry() {
        System.out.println("Married: Divorced -> Married");
        return new Married();
    }

    public MaritalStatus divorce() {
        System.out.println("Cannot divorce: person is Divorced");
        return this;
    }
}
