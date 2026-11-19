public class Married implements MaritalStatus {
    public String name() { return "Married"; }

    public MaritalStatus marry() {
        System.out.println("Cannot marry: person is already Married");
        return this;
    }

    public MaritalStatus divorce() {
        System.out.println("Divorced: Married -> Divorced");
        return new Divorced();
    }
}
