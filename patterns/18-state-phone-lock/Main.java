public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.pressKey("555-0100");
        phone.unlock();
        phone.pressKey("555-0100");
        phone.lock();
    }
}
