public class Single implements MaritalStatus {
    public String name() { return "Single"; }

    public MaritalStatus marry() {
        System.out.println("Married: Single -> Married");
        return new Married();
    }

    public MaritalStatus divorce() {
        System.out.println("Cannot divorce: person is Single");
        return this;
    }
}
