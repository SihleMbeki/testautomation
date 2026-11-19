public class Person {
    private MaritalStatus status = new Single();

    public void marry() { status = status.marry(); }
    public void divorce() { status = status.divorce(); }
    public String status() { return status.name(); }
}
