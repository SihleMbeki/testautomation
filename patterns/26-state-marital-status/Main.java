public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Status: " + person.status());
        person.divorce();
        person.marry();
        person.marry();
        person.divorce();
        person.divorce();
        person.marry();
        System.out.println("Final status: " + person.status());
    }
}
