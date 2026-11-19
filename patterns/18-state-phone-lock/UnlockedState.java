public class UnlockedState implements PhoneState {
    public void pressKey(Phone phone, String key) {
        System.out.println("Dialling " + key + ".");
    }
    public void unlock(Phone phone) {
        System.out.println("Phone is already unlocked.");
    }
    public void lock(Phone phone) {
        System.out.println("Phone locked.");
        phone.setState(new LockedState());
    }
}
