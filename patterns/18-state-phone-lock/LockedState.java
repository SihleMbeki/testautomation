public class LockedState implements PhoneState {
    public void pressKey(Phone phone, String key) {
        System.out.println("Phone is locked; key ignored.");
    }
    public void unlock(Phone phone) {
        System.out.println("Phone unlocked.");
        phone.setState(new UnlockedState());
    }
    public void lock(Phone phone) {
        System.out.println("Phone is already locked.");
    }
}
